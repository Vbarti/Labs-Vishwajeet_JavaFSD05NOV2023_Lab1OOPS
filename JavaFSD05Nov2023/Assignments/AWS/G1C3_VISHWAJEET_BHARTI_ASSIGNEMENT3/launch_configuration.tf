# launch_configuration.tf

resource "aws_launch_configuration" "nginx_lc" {
  name = "nginx-launch-config"
  image_id = var.ami_id
  instance_type = var.instance_type
  security_groups = [aws_security_group.allow_http.id]
  user_data = <<-EOT
              #!/bin/bash
              sudo apt update -y
              sudo apt install -y nginx
              sudo systemctl start nginx
              sudo systemctl enable nginx
              echo "<h1>Welcome to Nginx on Terraform!</h1>" | sudo tee /var/www/html/index.html
              EOT
}
