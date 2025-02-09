
variable "instance_metadata" {
  type = map(object({
    name = string
  }))
}
