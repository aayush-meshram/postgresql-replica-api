
###################################################
# Security Group for Postgres Instances - PRIMARY #
###################################################

resource "aws_security_group" "aws_sg_psql_primary" {
  name        = "allow_psql_traffic_primary"
  description = "Allow Postrgres specific inbound traffic and all outbound traffic for primary instances"
  vpc_id      = "vpc-030f3d491b1689a30"

  tags = {
    Name = "allow_psql_primary"
  }
}

resource "aws_vpc_security_group_ingress_rule" "allow_tls_ipv4" {
  security_group_id = aws_security_group.aws_sg_psql_primary.id
  cidr_ipv4         = "10.0.128.0/25"
  from_port         = 5432
  ip_protocol       = "tcp"
  to_port           = 5432
}

resource "aws_vpc_security_group_egress_rule" "allow_all_traffic_ipv4" {
  security_group_id = aws_security_group.aws_sg_psql_primary.id
  cidr_ipv4         = "0.0.0.0/0"
  ip_protocol       = "-1" # semantically equivalent to all ports
}



###################################################
# Security Group for Postgres Instances - REPLICA #
###################################################

resource "aws_security_group" "aws_sg_psql_replica" {
  name        = "allow_psql_traffic_primary"
  description = "Allow Postrgres specific inbound traffic and all outbound traffic for replica instances"
  vpc_id      = "vpc-030f3d491b1689a30"

  tags = {
    Name = "allow_psql_replicas"
  }
}

resource "aws_vpc_security_group_ingress_rule" "allow_tls_ipv4" {
  security_group_id = aws_security_group.aws_sg_psql_replica.id
  cidr_ipv4         = "10.0.128.128/25"
  from_port         = 5432
  ip_protocol       = "tcp"
  to_port           = 5432
}

resource "aws_vpc_security_group_egress_rule" "allow_all_traffic_ipv4" {
  security_group_id = aws_security_group.aws_sg_psql_replica.id
  cidr_ipv4         = "0.0.0.0/0"
  ip_protocol       = "-1" # semantically equivalent to all ports
}
