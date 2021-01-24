package com.rpg.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * {@link HelperUtil} utility class for helper methods
 */
public class HelperUtil {

    /**
     * Reads text file into stream
     */
    public List<String> readLines(String filePath) throws IOException {
        //FileReader reader = new FileReader(filePath);
        InputStreamReader streamReader = new InputStreamReader(this.getClass()
                .getResourceAsStream("/" + filePath));
        BufferedReader br = new BufferedReader(streamReader);
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }
        br.close();
        return lines;
    }

    public List<String> readStatusFile(String filePath) throws IOException {
        FileReader reader = new FileReader(filePath);
        BufferedReader br = new BufferedReader(reader);
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }
        br.close();
        return lines;
    }

    public void writeGameState(String filePath, String text) throws IOException {
        String tempPath = System.getProperty("java.io.tmpdir");
        //String dir = this.getClass().getResource(tempPath).getFile();
        OutputStream outStream = new FileOutputStream(tempPath + File.separator + filePath);
        PrintStream printStream = new PrintStream(outStream);
        printStream.println(text);
        printStream.close();
    }

    /**
     * Generate random number
     */
    public int generateRandom(int limit) {
        Random r = new Random();
        return r.nextInt(limit);
    }
}
