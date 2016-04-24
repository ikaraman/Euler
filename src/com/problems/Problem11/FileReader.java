package com.problems.Problem11;

import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FileReader {
    public static void main(String pathToFile) {

    }
    public static String readAndReturn(String path) {

        File f = new File(path);
        String stringFile = "";

        try {
            FileInputStream fs = new FileInputStream(f);
            InputStreamReader in = new InputStreamReader(fs);
            BufferedReader br = new BufferedReader(in);

            String text;

            while(true)
            {
                text=br.readLine();
                stringFile = stringFile + text + " ";
                if(text==null)
                    break;
                //System.out.println(text);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return stringFile;
    }
}