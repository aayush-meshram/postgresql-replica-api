package com.example.tfpsql.service;

import com.example.tfpsql.entity.PostgresConfigEntity;
import com.example.tfpsql.helper.CommandLineHelper;
import com.example.tfpsql.helper.AppendData;
import org.springframework.stereotype.Service;

@Service
public class PostgresConfigService {

    CommandLineHelper commandLineHelper;

    public String tfPlan(PostgresConfigEntity entity) {
        commandLineHelper = new CommandLineHelper();
        AppendData data = new AppendData();
        data.put(entity.getDatabaseName());
        String temp = commandLineHelper.execute("terraform init");
        return commandLineHelper.execute("terraform plan");
    }
}
