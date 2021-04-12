package com.vadzimvincho.textbook.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileManager.class);
    private static final String ORIGINAL_FILE = "./src/main/resources/textbook.txt";
    private static final String MODIFIED_FILE = "./src/main/resources/textbook_modified.txt";

    public String readTextbook() {
        String textbook = null;
        try {
            textbook = new String(getClass().getClassLoader().getResourceAsStream("textbook.txt").readAllBytes());
            //textbook = Files.readString(Paths.get(ORIGINAL_FILE), StandardCharsets.UTF_8);
        } catch (FileNotFoundException e) {
            LOGGER.error("File not found.");
        } catch (IOException e) {
            LOGGER.error("Error reading to file. " + e.getMessage());
        }
        LOGGER.info("The file was read successfully.");
        return textbook;
    }

    public void writeTextbook(String text) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(MODIFIED_FILE))) {
            bufferedWriter.write(text);
            bufferedWriter.flush();
        } catch (FileNotFoundException e) {
            LOGGER.error("File not found.");
        } catch (IOException e) {
            LOGGER.error("Error writing to file. " + e.getMessage());
        }
        LOGGER.info("The file was written successfully.");
//        try {
//            Files.write(Paths.get(MODIFIED_FILE), text.getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
