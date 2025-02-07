
variable "instance_data" {
  type = map(object({
    instance_name         = string
  }))
}