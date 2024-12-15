# outputs.tf

output "load_balancer_dns" {
  description = "DNS of the Load Balancer"
  value       = aws_lb.nginx_lb.dns_name
}
