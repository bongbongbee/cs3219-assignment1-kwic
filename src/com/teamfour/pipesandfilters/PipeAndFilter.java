package com.teamfour.pipesandfilters;

import java.io.FileInputStream;
import java.io.IOException;

public class PipeAndFilter {
	public static void main(String[] args) {
		try {
			FileInputStream inputSentences = new FileInputStream("input.txt");
			FileInputStream ignoredKeywords = new FileInputStream("ignoredWords.txt");

			Pipe input_circularShift = new Pipe();
			Pipe circularShift_alphabetizer = new Pipe();
			Pipe alphabetizer_output = new Pipe();
			
			Filter input = new Input(ignoredKeywords,inputSentences, input_circularShift);
			Filter circularShifter = new CircularShift(input_circularShift, circularShift_alphabetizer);
			Filter alphabetizer = new Alphabetizer(circularShift_alphabetizer, alphabetizer_output);
			Filter output = new Output(alphabetizer_output, null);
			
			startFilters(input,circularShifter,alphabetizer,output);
			
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void startFilters(Filter input, Filter circularShifter, Filter alphabetizer, Filter output) 
	{
		input.start();
		circularShifter.start();
		alphabetizer.start();
		output.start();		
	}
}
