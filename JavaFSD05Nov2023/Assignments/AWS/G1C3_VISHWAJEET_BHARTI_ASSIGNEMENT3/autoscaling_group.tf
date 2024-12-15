# autoscaling_group.tf

resource "aws_autoscaling_group" "nginx_asg" {
  desired_capacity     = var.desired_capacity
  max_size             = var.max_size
  min_size             = var.min_size
  vpc_zone_identifier  = [aws_subnet.subnet.id]
  launch_configuration = aws_launch_configuration.nginx_lc.id
  target_group_arns    = [aws_lb_target_group.nginx_target_group.arn]

  tag {
    key                 = "Name"
    value               = "NginxInstance"
    propagate_at_launch = true
  }
}
