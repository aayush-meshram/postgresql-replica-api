output "security_groups" {
  value = aws_security_group.aws_sg
}

output "ec2_instances_primary" {
  value = aws_instance.ec2
}

output "ec2_instances_replica" {
  value = aws_instance.ec2_replica
}