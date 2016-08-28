package com.teamfour.pipesandfilters;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.teamfour.utilities.AlphabeticalOrder;

public class Alphabetizer extends Filter {

	public Alphabetizer(Pipe input, Pipe output) {
		super(input, output);
	}

	@Override
	protected void transform() {
		try {

			ArrayList<String> lines = new ArrayList<String>();
			CharArrayWriter writer = new CharArrayWriter();
			int c = input_.readInput();
			while (c != -1) {
				writer.write(c);
				if (((char) c) == '\n') {
					String line = writer.toString();
					lines.add(line);
					writer.reset();
				}
				c = input_.readInput();
			}		
			
			for(int p=0;p<lines.size();p++)
			{
				String[] chopToSmallerString = lines.get(p).split(" ");
				for(int k=0;k<input_.readIgnoredWords().length;k++)
				{
					if(chopToSmallerString[0].toLowerCase().equals(input_.readIgnoredWords()[k].toLowerCase()))
					{
						lines.remove(p);
						p--;
						break;
					}
				}
			}
			AlphabeticalOrder ao = null;
			Collections.sort(lines, ALPHABETICAL_ORDER);

			ArrayList<String> resultList = new ArrayList<String>();
			for(int x=0;x<lines.size();x++)
			{
				String[] chopToSmallerString = lines.get(x).split(" ");

				String currentString="";
				
				for(int y=0;y<chopToSmallerString.length;y++)
				{
					String tempStore="";


					for(int k=0;k<input_.readIgnoredWords().length;k++)
					{
						chopToSmallerString[y] = chopToSmallerString[y].replaceAll("\\s","");

						if(chopToSmallerString[y].toLowerCase().equals(input_.readIgnoredWords()[k].toLowerCase()))
						{
							chopToSmallerString[y] = chopToSmallerString[y].toLowerCase();
						}
						tempStore = chopToSmallerString[y];

					}
					
					currentString+=tempStore+ " ";

				}		
				
				resultList.add(removeLastChararacter(currentString));

			}

			output_.writeOutputArray(resultList.toArray(new String[resultList.size()]));
			output_.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static Comparator<String> ALPHABETICAL_ORDER = new Comparator<String>() {
	    public int compare(String str1, String str2) {
	        int x = String.CASE_INSENSITIVE_ORDER.compare(str1, str2);
	        if (x == 0) {
	            x = str1.compareTo(str2);
	        }
	        return x;
	    }
	};
	private static String removeLastChararacter(String str) {
        return str.substring(0,str.length()-1);
    }

}
