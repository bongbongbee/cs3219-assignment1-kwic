package com.teamfour.implicitinvocations;

public class Output {

    public static void print(LineStorage lineStorage){
        lineStorage.sort();
        
        while(lineStorage.hasNextLine()){
            System.out.println(lineStorage.getLine());
        }
    }
}
    