package com.problems.Problem13;

import com.problems.Problem11.FileReader;

public class Problem13 {
    public static void main(String[] args) {
        String pathToFile = "c:/javafile3.txt";
        String file;
        file = FileReader.readAndReturn(pathToFile);
        System.out.println(file);
    }

    public static Long sum(Long num1, Long num2){
        Long result = 0L;
        result = num1 + num2;
        return result;
    }

    public static void fileIntoArray (String path){

    }
}

