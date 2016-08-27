package com.teamfour.implicitinvocations;

public class ImplicitInvocation {

    public ImplicitInvocation() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        Input input = new Input();
        LineStorage originalLines = new LineStorage();
        LineStorage shiftedLines = new LineStorage();
        CircularShifter circularShifter = new CircularShifter(shiftedLines);
        Alphabetizer alphabetizer = new Alphabetizer();

        originalLines.addObserver(circularShifter);
        shiftedLines.addObserver(alphabetizer);

        input.readInto(originalLines);
        Output.print(shiftedLines);
    }
}
