package com.example.tfpsql.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class CommandLineHelper {
    public String execute (String command)   {
        StringBuilder output = new StringBuilder();

        try {
            ProcessBuilder processBuilder = new ProcessBuilder();

            // If running on Linux/Mac, use "bash -c"
            processBuilder.command("bash", "-c", "terraform init");

            // If running on Windows, use "cmd.exe /c"
            // processBuilder.command("cmd.exe", "/c", command);


            Process process = processBuilder.start();

            // Read output
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    output.append(line).append("\n");
                }
            }

            int exitCode = process.waitFor();
            output.append("Exit Code: ").append(exitCode);

        } catch (IOException | InterruptedException e) {
            return "Error: " + e.getMessage();
        }

        return output.toString();
    }
}
