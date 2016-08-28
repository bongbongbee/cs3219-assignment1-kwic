package com.teamfour.pipesandfilters;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Pipe {
	private PipedReader reader;
	private PipedWriter writer;
	private String[] ignoredWords;
	private String[] resultArray;
	
	public Pipe() throws IOException {
		writer = new PipedWriter();
		reader = new PipedReader();
		writer.connect(reader);
	}
	
	public void writeOutput(int c) throws IOException {
		writer.write(c);
	}
	public void writeOutput(String[] ignoredWords) throws IOException {
		this.ignoredWords=ignoredWords;
	}
	public void writeOutputArray(String[] resultArray) throws IOException 
	{
		this.resultArray=resultArray;

	}
	public int readInput() throws IOException {
		return reader.read();
	}
	public String[] readIgnoredWords() throws IOException {
		return this.ignoredWords;
	}
	public String[] readResultList() throws IOException {
		return this.resultArray;
	}
	
	public void close() throws IOException {
		writer.flush();
		writer.close();
	}
	
	public void closeReader() throws IOException {
		reader.close();
	}
}
