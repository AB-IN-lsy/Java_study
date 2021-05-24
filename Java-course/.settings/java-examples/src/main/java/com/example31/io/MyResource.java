package com.example31.io;

public class MyResource implements AutoCloseable{
    @Override
    public void close() throws Exception {
        System.out.println("Closed");
    }
}
