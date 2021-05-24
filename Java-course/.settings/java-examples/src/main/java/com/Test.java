package com;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;



public class Test {
    private static void getThrows() throws IOException{
        Files.readString(Path.of("A:/aa.aa"));
    }

    public static void main(String[] args){
        try{
            getThrows();
        }
        catch (IOException e){
            System.out.println("False");
        }
    }
}
