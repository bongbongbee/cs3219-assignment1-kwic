package com.teamfour.implicitinvocations;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class LineStorage extends Observable {
    
    private ArrayList<String> lines;
    private int lastAddedIndex;
    
    /* (non-Javadoc)
     * @see java.util.Observable#addObserver(java.util.Observer)
     */
    @Override
    public synchronized void addObserver(Observer o) {
        // TODO Auto-generated method stub
        super.addObserver(o);
    }

    /* (non-Javadoc)
     * @see java.util.Observable#notifyObservers()
     */
    @Override
    public void notifyObservers() {
        // TODO Auto-generated method stub
        super.notifyObservers();
    }
    
    public LineStorage() {
        lines = new ArrayList<>();
    }
    
    public void addLine(String line){
        lines.add(line);
        this.notifyObservers(lastAddedIndex++);
        
    }
    
    public String getLine(int index){
        return lines.get(index);
    }

}
