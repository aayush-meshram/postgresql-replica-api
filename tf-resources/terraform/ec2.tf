
resource "aws_instance" "ec2" {
  for_each = var.pg_instances
  ami           = "ami-03c68e52484d7488f"  # debian-12-amd64-20240717-1811
  instance_type = "t2.micro"

  subnet_id = "subnet-071824d1339ca0e0d"
  depends_on = [aws_security_group.aws_sg_psql_primary]
  security_groups = [aws_security_group.aws_sg_psql_primary.id]

  tags = {
    Name = "Server-${each.value.name}-Primary"
  }
}

resource "aws_instance" "ec2_replica" {
  for_each = var.pg_instances
  ami           = "ami-03c68e52484d7488f"  # debian-12-amd64-20240717-1811
  instance_type = "t2.micro"

  subnet_id = "subnet-00c7b5c416207512d"
  depends_on = [aws_security_group.aws_sg_psql_replica]
  security_groups = [aws_security_group.aws_sg_psql_replica.id]

  tags = {
    Name = "Server-${each.value.name}-Replica"
  }
}