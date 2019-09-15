package com.rpsls.rsplsservice.utils;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResourceGetter {

    private ResourceGetter() {

    }

    private static final Logger LOGGER = Logger.getLogger(ResourceGetter.class.getName());

    /**
     * Gets a file from resources and returns its contents as a string.
     * @param fileName name of file including its relative path name in resources folder.
     * @return String representation of file contents.
     */
    public static String getFile(String fileName) {
        String data = null;
        try {
            Path path = Paths.get(ResourceGetter.class.getClassLoader().getResource(fileName).getPath());
            try (Stream<String> lines = Files.lines(path)) {
                data = lines.collect(Collectors.joining("\n"));
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, String.format("There was an exception when reading a file from resources folder: %s", e.getMessage()));
            }
        } catch (NullPointerException e) {
            LOGGER.log(Level.SEVERE, String.format("The file does not exist: %s: error: %s", fileName, e.getMessage()));
        }
        return data;
    }
}
