package com.example.tfpsql.service;

import com.example.tfpsql.entity.PostgresConfigEntity;
import com.example.tfpsql.helper.CommandLineHelper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostgresConfigService {

    CommandLineHelper commandLineHelper;

    public String tfPlan(PostgresConfigEntity postgresConfigEntity) {
        commandLineHelper = new CommandLineHelper();
        return commandLineHelper.execute("pwd");
    }
}
