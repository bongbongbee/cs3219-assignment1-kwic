package com.teamfour.implicitinvocations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;

import com.teamfour.utilities.AlphabeticalOrder;

public class LineStorage extends Observable {
    private ArrayList<String> lines;
    private int lastAddedIndex;

    public LineStorage() {
        lines = new ArrayList<>();
    }

    public void addLine(String line) {
        lines.add(line);
        setChanged();
        notifyObservers();
    }

    public String getLine() {
        return lines.get(lastAddedIndex++);
    }

    public boolean hasNextLine() {
        try {
            return lines.get(lastAddedIndex) != null;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public int getSize() {
        return lines.size();
    }

    public void sort() {
        // reset currentIndex
        lastAddedIndex = 0;
        
        Collections.sort(lines, AlphabeticalOrder.ALPHABETICAL_ORDER);
    }
}
