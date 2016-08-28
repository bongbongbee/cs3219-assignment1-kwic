package com.teamfour.implicitinvocations;

public class ImplicitInvocation {

    public static void run() {
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
