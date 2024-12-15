variable "region" {
  description = "The AWS region to create resources in"
  default     = "us-east-1"  # Default AWS region
}

variable "instance_type" {
  description = "The EC2 instance type"
  default     = "t2.micro"  # Default EC2 instance type
}

variable "az_1" {
  description = "The first availability zone to deploy resources"
  default     = "us-east-1a"
}

variable "az_2" {
  description = "The second availability zone to deploy resources"
  default     = "us-east-1b"
}

variable "desired_capacity" {
  description = "The desired number of instances in the Auto Scaling group"
  default     = 2
}

variable "max_size" {
  description = "The maximum size of the Auto Scaling group"
  default     = 3
}

variable "min_size" {
  description = "The minimum size of the Auto Scaling group"
  default     = 1
}
