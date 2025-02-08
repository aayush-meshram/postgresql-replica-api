package com.example.tfpsql.helper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class CommandLineHelper {
    public String execute (String command)   {
        StringBuilder output = new StringBuilder();
        try {
            // Run the command via the script on the host
            ProcessBuilder processBuilder = new ProcessBuilder("sh", "/app/run_command.sh", command);

            // Start the process
            Process process = processBuilder.start();

            // Read the output of the executed command
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            output.append(reader.lines().collect(Collectors.joining("\n")));

            // Wait for the process to finish and get the exit code
            int exitCode = process.waitFor();
            output.append("\nExit Code: ").append(exitCode);
        } catch (Exception e) {
            output.append("Error: ").append(e.getMessage());
        }
        return output.toString();
    }
}
