package com.edu.agh.CopyFile;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;

public class Copy {

    private static final String filePath = "";
    private Path path = Paths.get(filePath);



    public static void copy(String sourcePath, String destinationPath){

        try{
            Path source = Paths.get(sourcePath);
            Path dest = Paths.get(destinationPath);

            Files.copy(source, dest.resolve(source.getFileName()));
        }catch(FileNotFoundException e){
            System.out.println("File was not found in given source");
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copy(String sourcePath, String destinationPath, boolean checkDir) throws IOException {
            if(!checkDir)
                copy(sourcePath, destinationPath);

        try{
            Path source = Paths.get(sourcePath);
            Path dest = Paths.get(destinationPath);
            Files.copy(source, dest.resolve(source.getFileName()));

        }catch(FileNotFoundException e){
            e.printStackTrace();


        }catch(NoSuchFileException e){
            Files.createDirectories(Paths.get(destinationPath));
            copy(sourcePath, destinationPath, true);
        }
        catch(FileAlreadyExistsException e){
            System.out.println("File was overwritten");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args){
        if(args.length != 2){
            System.err.println("Usage <source> <target>");
            System.exit(-1);
        }

        String sourceFile = args[0];
        String destination = args[1];

        Path sourcePath = Paths.get(sourceFile);

        if(Files.notExists(sourcePath)){
            System.err.println("Source file" + sourceFile + "does not exists");
            System.exit(-2);
        }

        Path destinationPath = Paths.get(destination);

        if(Files.notExists(destinationPath)){
            try{
                Files.createDirectories(destinationPath);
            }catch (IOException e){
                e.printStackTrace();
                System.err.println("Cannot create directory" + destinationPath);
                System.exit(-3);
            }
        }

        if(Files.isDirectory(destinationPath)){
            destinationPath = destinationPath.resolve(sourcePath.getFileName());
        }
        System.out.println(destinationPath);

        try{
            Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e ){
            e.printStackTrace();
        }























    }


}
