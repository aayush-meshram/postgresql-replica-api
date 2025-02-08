resource "aws_security_group" "aws_sg_psql" {
  name        = "allow_psql_traffic"
  description = "Allow Postrgres specific inbound traffic and all outbound traffic"
  vpc_id      = "vpc-030f3d491b1689a30"

  tags = {
    Name = "allow_tls"
  }
}

resource "aws_vpc_security_group_ingress_rule" "allow_tls_ipv4" {
  security_group_id = aws_security_group.aws_sg_psql.id
  cidr_ipv4         = aws_vpc.main.cidr_block
  from_port         = 5432
  ip_protocol       = "tcp"
  to_port           = 5432
}

resource "aws_vpc_security_group_egress_rule" "allow_all_traffic_ipv4" {
  security_group_id = aws_security_group.aws_sg_psql.id
  cidr_ipv4         = "0.0.0.0/0"
  ip_protocol       = "-1" # semantically equivalent to all ports
}
