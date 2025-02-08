
variable "pg_instances" {
  type = map(object({
    name = string
  }))
}
