resource "aws_instance" "ec2" {
  ami           = "ami-03c68e52484d7488f"  # debian-12-amd64-20240717-1811
  instance_type = "t2.micro"

  subnet_id = "subnet-071824d1339ca0e0d"
  tags = {
    Name = "Server-${each.value.name}-Primary"
  }
}

resource "aws_instance" "ec2_replica" {
  ami           = "ami-03c68e52484d7488f"  # debian-12-amd64-20240717-1811
  instance_type = "t2.micro"

  subnet_id = "subnet-00c7b5c416207512d"
  tags = {
    Name = "Server-${each.value.name}-Replica"
  }
}