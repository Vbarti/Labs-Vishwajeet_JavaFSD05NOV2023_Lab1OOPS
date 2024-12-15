# variables.tf

variable "aws_region" {
  description = "The AWS region to deploy resources"
  default     = "us-east-1"
}

variable "instance_type" {
  description = "EC2 instance type"
  default     = "t2.micro"
}

variable "desired_capacity" {
  description = "Desired number of instances in ASG"
  default     = 2
}

variable "min_size" {
  description = "Minimum number of instances in ASG"
  default     = 1
}

variable "max_size" {
  description = "Maximum number of instances in ASG"
  default     = 3
}

variable "ami_id" {
  description = "AMI ID for EC2 instances"
}
