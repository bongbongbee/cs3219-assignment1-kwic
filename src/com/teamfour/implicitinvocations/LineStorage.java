package com.teamfour.implicitinvocations;

import java.util.ArrayList;
import java.util.Observable;

public class LineStorage extends Observable {

    private ArrayList<String> lines;
    
    public LineStorage() {
        lines = new ArrayList<>();
    }
    
    public void addLine(String line){
        lines.add(line);
    }
    
    public String getLine(int index){
        return lines.get(index);
    }

}
