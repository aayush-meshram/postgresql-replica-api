package com.example.tfpsql.entity;

import java.util.Map;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostgresConfigEntity {
    private String databaseName;
    private Map<String, String> configParameters; // Stores key-value pairs of PostgreSQL settings
}
