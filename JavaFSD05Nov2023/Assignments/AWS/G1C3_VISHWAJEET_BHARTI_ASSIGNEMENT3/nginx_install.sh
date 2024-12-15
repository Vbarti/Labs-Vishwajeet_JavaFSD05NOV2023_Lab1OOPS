#!/bin/bash
# Install Nginx on Amazon Linux 2
sudo yum update -y
sudo amazon-linux-extras enable nginx1
sudo yum install nginx -y
sudo service nginx start
sudo chkconfig nginx on
