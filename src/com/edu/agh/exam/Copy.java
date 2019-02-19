package com.edu.agh.exam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Copy {

    private final String sourceFile;
    private final String destination;
    private Path sourcePath;
    private Path destinationPath;

    public Copy(String sourceFile, String destination) {
        this.sourceFile = sourceFile;
        this.destination = destination;
    }

    private void setSourcePath() {
        sourcePath = Paths.get(sourceFile);
        if(Files.notExists(sourcePath)){
            sourcePath = null;
            System.err.println("File " + sourceFile + "does not exist");
        }
    }

    private void setDestinationPath() {
        destinationPath = Paths.get(destination);
        if(Files.notExists(destinationPath)) {
            try {
                Files.createDirectory(destinationPath);
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Cannot create directory" + destinationPath);
            }
        }
    }

    public void copyFile () {
        setSourcePath();
        setDestinationPath();
        System.out.println(destinationPath);
        if(Files.isDirectory(destinationPath)) {
            destinationPath = destinationPath.resolve(sourcePath.getFileName());
            System.out.println(destinationPath);
        }

        try {
            Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        Copy file = new Copy("Person.txt", "src/outTest/FileToBeReplaced.txt");

        file.copyFile();

        // to copy file I need to have 2 Paths Path source = Paths.get(String) and destination
        // It is important to check either path exists
        // if source doesn't then throw exception
        // if destination doesn't please create directory in given path, if Path is incorrect throw exception
        //




    }
}
