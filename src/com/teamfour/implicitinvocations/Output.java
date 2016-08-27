package com.teamfour.implicitinvocations;

public class Output {

    public static void print(LineStorage lineStorage){
        lineStorage.sort();
        String line;
        while((line = lineStorage.getLine()) != null){
            System.out.println(line);
        }
    }
}
