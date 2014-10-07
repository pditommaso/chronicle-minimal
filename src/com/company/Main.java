package com.company;

import java.io.File;
import java.io.IOException;

import net.openhft.chronicle.map.*;

public class Main {

    public static void main(String[] args) throws IOException {

        final String pathname = "myfile.dat";

        File file = new File(pathname);

        ChronicleMap map = ChronicleMapBuilder
                .of(Integer.class, CharSequence.class)
                .entries(4000000)
                .create(file);

        map.put(1, "Hello");

        map.close();
    }
}
