package com.teamfour.pipesandfilters;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Input extends Filter {
	private InputStream input;
	private InputStream ignoredWords;
	public Input(FileInputStream ignoredKeywords, FileInputStream inputSentences, Pipe output) {
		super(null, output);
		ignoredWords = ignoredKeywords;
		input = inputSentences;
	}

	@Override
	protected void transform() {
		try {
			
			final String comma = ",";
			byte[] data = new byte[ignoredWords.available()];
			ignoredWords.read(data);
			ignoredWords.close();
			String manyIgnoredWords = new String(data, "UTF-8");
			manyIgnoredWords= manyIgnoredWords.toLowerCase();
			//String[] stringArraySentences = manySentence.split(comma);
			String[] stringArrayIgnored = manyIgnoredWords.split("\n");
			
			//System.out.println("stringArrayIgnored length is : " + stringArrayIgnored.length);
			for(int x=0;x<stringArrayIgnored.length;x++)
			{
				if(x<stringArrayIgnored.length-1)
				{
					stringArrayIgnored[x] = stringArrayIgnored[x].substring(0, stringArrayIgnored[x].length() - 1);

				}
			}
			/*for(int x=0;x<stringArraySentences.length;x++)
			{
				if(stringArraySentences[x].startsWith(" "))
				{
					stringArraySentences[x] = stringArraySentences[x].substring(1);
				}
			}*/
			output_.writeOutput(stringArrayIgnored);
			
			boolean newLine = false;
			boolean newWord = false;
			boolean lineStart = false;
			
			int singleChar = input.read();
			while (singleChar != -1) {
				if((byte)singleChar == '\n'){
					newLine=true;
				}
				else if((byte)singleChar == ' '){
					newWord=true;
				}
				else if((byte)singleChar == '\t'){
					newWord=true;
				}
				else if((byte)singleChar == '\r'){
				}
				else{
					if (newLine) {
						output_.writeOutput('\n');
						newLine = false;
						lineStart = false;
					}
					if (newWord) {
						if (lineStart) {
							output_.writeOutput(' ');
						}
						newWord = false;
					}
					output_.writeOutput(singleChar);
					lineStart = true;
				}
				singleChar = input.read();
			}
			output_.writeOutput('\n');
			output_.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
