package com.example.tfpsql.helper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.time.Instant;

public class AppendData {
    public void put(String dbName) {
        String filePath = "terraform.tfvars.json";
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read existing JSON file
            File file = new File(filePath);
            JsonNode rootNode = file.exists() ? objectMapper.readTree(file) : objectMapper.createObjectNode();

            // Ensure "instance_metadata" exists
            ObjectNode instanceMetadata = (rootNode.has("instance_metadata"))
                    ? (ObjectNode) rootNode.get("instance_metadata")
                    : objectMapper.createObjectNode();

            // Create new instance entry
            ObjectNode newInstance = objectMapper.createObjectNode();
            newInstance.put("name", dbName);

            // Append new instance
            Instant time = Instant.now();
            instanceMetadata.set(dbName+time, newInstance);
            ((ObjectNode) rootNode).set("instance_metadata", instanceMetadata);

            // Write updated JSON back to file
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, rootNode);
            System.out.println("JSON file updated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
