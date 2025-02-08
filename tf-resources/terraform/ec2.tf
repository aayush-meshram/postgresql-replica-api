
resource "aws_instance" "ec2" {
  for_each = var.pg_instances
  ami           = "ami-03c68e52484d7488f"  # debian-12-amd64-20240717-1811
  instance_type = "t2.micro"

  subnet_id = each.subnet_id
  depends_on = [aws_security_group.aws_sg_psql]
  security_groups = aws_security_group.aws_sg_psql.id

  tags = {
    Name = "Server-${each.value.name}"
  }
}