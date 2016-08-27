package com.teamfour.implicitinvocations;

import java.util.ArrayList;
import java.util.Observable;

public class LineStorage extends Observable {

    private ArrayList<String> lines;
    
    public LineStorage() {
        lines = new ArrayList<>();
    }

}
