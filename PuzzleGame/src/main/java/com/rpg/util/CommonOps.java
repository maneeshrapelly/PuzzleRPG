package com.rpg.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CommonOps {

    public List<String> readLines(String filePath) throws IOException {
        //FileReader reader = new FileReader(filePath);
        InputStreamReader  streamReader = new InputStreamReader(this.getClass()
                .getResourceAsStream("/"+filePath));
        BufferedReader br = new BufferedReader(streamReader);
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }
        br.close();
        return lines;
    }

    public static int generateRandom(int limit) {
        Random r = new Random();
        return r.nextInt(limit);
    }
}
