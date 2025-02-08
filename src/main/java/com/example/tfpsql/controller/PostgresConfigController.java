package com.example.tfpsql.controller;

import com.example.tfpsql.entity.PostgresConfigEntity;
import com.example.tfpsql.service.PostgresConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostgresConfigController {

    @Autowired
    PostgresConfigService postgresConfigService;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }

    @PostMapping("/tfplan")
    public ResponseEntity<String> tfPlan(@RequestBody PostgresConfigEntity postgresConfigEntity) {
        return new ResponseEntity<>( postgresConfigService.tfPlan(postgresConfigEntity), HttpStatus.OK);
    }
}
