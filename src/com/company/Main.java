package com.company;

import java.io.File;
import java.io.IOException;

import net.openhft.chronicle.map.*;

public class Main {

    public static void main(String[] args) throws IOException {

        final String pathname = "myfile.dat";
        final long entries = args.length > 0 ? Long.parseLong(args[0]) : 1_000_000L; 

        File file = new File(pathname);
        long begin = System.currentTimeMillis();
        
        System.out.printf("1. Begin using %5d entries\n", entries);
        ChronicleMap map = ChronicleMapBuilder
                .of(Integer.class, CharSequence.class)
                .entries(entries)
                .create(file);

        System.out.printf("2. After create: %5d ms\n", System.currentTimeMillis()-begin);
        begin = System.currentTimeMillis();
        
        map.put(1, "Hello");
        System.out.printf("3. After put: %5d ms\n", System.currentTimeMillis()-begin);
        begin = System.currentTimeMillis();
        
        map.close();
        System.out.printf("4. After close: %5d ms\n", System.currentTimeMillis()-begin);
        
    }
}
