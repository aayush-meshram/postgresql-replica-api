output "security_groups_primary" {
  value = aws_security_group.aws_sg_psql_primary
}

output "security_groups_replica" {
  value = aws_security_group.aws_sg_psql_replica
}

output "ec2_instances_primary" {
  value = aws_instance.ec2
}

output "ec2_instances_replica" {
  value = aws_instance.ec2_replica
}