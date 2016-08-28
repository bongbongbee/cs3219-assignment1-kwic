package com.teamfour.implicitinvocations;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Output {

    public static void print(LineStorage lineStorage) {
        lineStorage.sort();
        saveOutputToFile(lineStorage);
    }

    private static void saveOutputToFile(LineStorage lineStorage) {
        Path path = Paths.get("output2.txt");

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {

            while (lineStorage.hasNextLine()) {
                writer.write(lineStorage.getLine());
                
                //prevent writing a new line after the last line
                if (!lineStorage.hasNextLine()) {
                    break;
                }
                writer.newLine();
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Error encounted while saving output to file.");
            System.exit(1);
        }

    }
}