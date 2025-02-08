terraform {
  backend "local" {
    path = "/home/admin/terraform/terraform.tfstate"
  }
}

provider "aws" {
  region = "ap-south-1"
}