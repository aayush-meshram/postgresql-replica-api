package com.example.tfpsql.service;

import com.example.tfpsql.entity.PostgresConfigEntity;
import com.example.tfpsql.helper.CommandLineHelper;
import com.example.tfpsql.helper.AppendData;
import org.apache.commons.text.StringSubstitutor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

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

    public String printCode(PostgresConfigEntity entity)    {
        String filePath = "../template/ec2-template.tf";
        String placeholder = "${each.value.name}";
        String replacementValue = entity.getDatabaseName(); // Replace with your desired value
        String updatedContent = "";
        try {
            // Read the content of the template file
            String content = new String(Files.readAllBytes(Paths.get(filePath)));

            // Replace the placeholder with the specified value
            updatedContent = content.replace(placeholder, replacementValue);

            // Print the updated content
            System.out.println("Updated Terraform Configuration:\n");
            System.out.println(updatedContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return updatedContent;
    }
}
