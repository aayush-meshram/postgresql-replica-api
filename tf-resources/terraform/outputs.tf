output "security_groups" {
  value = aws_security_group.aws_sg
}

output "ec2_instances" {
  value = aws_instance.ec2
}