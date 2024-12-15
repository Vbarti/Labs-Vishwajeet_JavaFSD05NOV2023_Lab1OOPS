provider "aws" {
  region = var.region  # Use the region variable from variables.tf
}

# Fetch the default VPC
data "aws_vpc" "default_vpc" {
  default = true
}

# Create a default security group
resource "aws_security_group" "allow_http" {
  name        = "allow_http"
  description = "Allow HTTP and SSH traffic"
  
  ingress {
    from_port   = 80
    to_port     = 80
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

# Automatically find the latest Amazon Linux 2 AMI (for EC2 instances)
data "aws_ami" "latest_amazon_linux" {
  most_recent = true
  owners      = ["amazon"]
  filter {
    name   = "name"
    values = ["amzn2-ami-hvm-*-x86_64-gp2"]
  }
}

# Launch Configuration to use the Amazon Linux 2 AMI and install Nginx
resource "aws_launch_configuration" "nginx_config" {
  name = "nginx-launch-config"
  image_id = data.aws_ami.latest_amazon_linux.id
  instance_type = var.instance_type  # Use the instance type variable
  security_groups = [aws_security_group.allow_http.id]
  user_data = file("nginx_install.sh")  # Executes the shell script to install Nginx

  lifecycle {
    create_before_destroy = true
  }
}

# Automatically find default subnets in the default VPC
data "aws_subnet" "default_subnet_1" {
  vpc_id = data.aws_vpc.default_vpc.id
  availability_zone = var.az_1  # Use AZ variable
}

data "aws_subnet" "default_subnet_2" {
  vpc_id = data.aws_vpc.default_vpc.id
  availability_zone = var.az_2  # Use AZ variable
}

# Create the Auto Scaling Group (ASG)
resource "aws_autoscaling_group" "nginx_asg" {
  desired_capacity     = var.desired_capacity
  max_size             = var.max_size
  min_size             = var.min_size
  vpc_zone_identifier  = [data.aws_subnet.default_subnet_1.id, data.aws_subnet.default_subnet_2.id]
  launch_configuration = aws_launch_configuration.nginx_config.id

  health_check_type          = "EC2"
  health_check_grace_period = 300
  force_delete              = true
  wait_for_capacity_timeout  = "0"
}

# Create Elastic Load Balancer (ELB)
resource "aws_lb" "nginx_lb" {
  name               = "nginx-lb"
  internal           = false
  load_balancer_type = "application"
  security_groups   = [aws_security_group.allow_http.id]
  subnets            = [data.aws_subnet.default_subnet_1.id, data.aws_subnet.default_subnet_2.id]

  enable_deletion_protection = false
  idle_timeout            = 60
}

# Create a Target Group for the Load Balancer
resource "aws_lb_target_group" "nginx_target_group" {
  name     = "nginx-target-group"
  port     = 80
  protocol = "HTTP"
  vpc_id   = data.aws_vpc.default_vpc.id

  health_check {
    interval = 30
    path     = "/"
    port     = 80
    protocol = "HTTP"
    timeout  = 5
    healthy_threshold   = 3
    unhealthy_threshold = 3
  }
}

# Set up a listener for the Load Balancer to forward traffic
resource "aws_lb_listener" "nginx_listener" {
  load_balancer_arn = aws_lb.nginx_lb.arn
  port              = 80
  protocol          = "HTTP"

  default_action {
    target_group_arn = aws_lb_target_group.nginx_target_group.arn
    type             = "fixed-response"
	fixed_response {
      status_code = 200
      content_type = "text/plain"
      message_body = "Welcome to the Nginx Load Balancer!"
    }
  }
}

# Attach the Auto Scaling Group to the Load Balancer
resource "aws_autoscaling_attachment" "nginx_asg_attachment" {
  autoscaling_group_name = aws_autoscaling_group.nginx_asg.id
  lb_target_group_arn  = aws_lb_target_group.nginx_target_group.arn

  depends_on = [
    aws_lb_target_group.nginx_target_group  # Ensure target group is created first
  ]
}

# Output the DNS of the Load Balancer
output "load_balancer_dns" {
  description = "The DNS of the load balancer"
  value       = aws_lb.nginx_lb.dns_name
}
