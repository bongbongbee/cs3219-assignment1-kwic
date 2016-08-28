package com.teamfour.pipesandfilters;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class CircularShift extends Filter {

	
	public CircularShift(Pipe input, Pipe output) {
		super(input, output);
	}

	@Override
	protected void transform() {
		try {
			CharArrayWriter writer = new CharArrayWriter();
			int k = input_.readInput();
			String[] ignoredWords = input_.readIgnoredWords();
			while (k != -1) {
				
				if (((char) k) == '\n') {
				
					String line = writer.toString();
					StringTokenizer strTokenizer = new StringTokenizer(line);
					String[] numberOfWords = new String[strTokenizer.countTokens()];
					//System.out.println("|line : |" + line + "| number of toknizer count: |"+strTokenizer.countTokens());


					int i = 0;
					while (strTokenizer.hasMoreTokens()) {
						numberOfWords[i++] = strTokenizer.nextToken();
					}
					//System.out.println("|line : |" + line + "| number of words length: |"+numberOfWords.length);

					for (i = 0; i < numberOfWords.length; i++) {
						String shift = "";
						for (int j = i; j < (numberOfWords.length + i); j++) {
							shift += numberOfWords[j % numberOfWords.length];
							if (j < (numberOfWords.length - 1 + i)) {
								shift += " ";
							}	
							//System.out.println(shift);
						}
						shift += '\n';
						
						char[] chars = shift.toCharArray();
						
						for (int j = 0; j < chars.length; j++) 
						{
							output_.writeOutput(chars[j]);
							
						}				
					}
					writer.reset();
				} 
				else
				{
					writer.write(k);
				
				}
				k = input_.readInput();
			}
			output_.writeOutput(ignoredWords);
			output_.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
