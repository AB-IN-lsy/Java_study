package com;

import com.example06.accesslevel.MyLevel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class Test{

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
        String a = "java";
        String b = new String("java");
        System.out.println(a.equals(b));
        System.out.println(a == b);
    }
}
