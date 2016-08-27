package com.teamfour.implicitinvocations;

import java.util.ArrayList;
import java.util.Observable;

public class LineStorage extends Observable {
    
    private ArrayList<String> lines;
    private int lastAddedIndex;
    
    public LineStorage() {
        lines = new ArrayList<>();
    }
    
    public void addLine(String line){
        lines.add(line);
        setChanged();
        notifyObservers();
        
    }
    
    public String getLine(){
        return lines.get(lastAddedIndex++);
    }
    
    public int getSize(){
        return lines.size();
    }

}
