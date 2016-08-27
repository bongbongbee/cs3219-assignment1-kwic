package com.teamfour.implicitinvocations;

import java.util.Observable;
import java.util.Observer;

public class Alphabetizer implements Observer {
    private LineStorage shiftedLines;
    
    public Alphabetizer() {
    }

    @Override
    public void update(Observable o, Object arg) {
        if(!(o instanceof LineStorage)){
            return;
        }
        
        shiftedLines = (LineStorage) o;
        String line = shiftedLines.getLine();
        String firstCharUpperCase = Character.toString(line.charAt(0)).toUpperCase();
        String lineWithFirstCharUpperCase = firstCharUpperCase + line.substring(1);
        line = lineWithFirstCharUpperCase;
        
    }

}
