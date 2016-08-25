package com.teamfour.pipesandfilters;
import java.util.ArrayList;
import java.util.Arrays;

public class CircularShift {

	
	public CircularShift()
	{
		
	}
	public ArrayList<String> fetchCircularList(String[] ignoredList, String[] sentenceList) {

		final String space = " ";
		ArrayList<String> resultList = new ArrayList<String>();
		
		for(int x=0;x<sentenceList.length;x++)
		{
			String[] singleSentenceToArray = sentenceList[x].split(space);
			
			for(int k=0;k<singleSentenceToArray.length;k++)
			{
				for(int y=0;y<ignoredList.length;y++)
				{

					if(ignoredList[y].equals(singleSentenceToArray[0]) || capitalize(ignoredList[y]).equals(singleSentenceToArray[0]) )//cap or dont cap both need to check
					{
						//covert the array to arraylist
						ArrayList<String> currentSentence = new ArrayList<String>(Arrays.asList(singleSentenceToArray));
						//add to the btm
						currentSentence.add(currentSentence.get(0));
						currentSentence.remove(0);
						currentSentence.toArray(singleSentenceToArray);
						//remove the first
						
						break;
					}
					else if(y==ignoredList.length-1 && ignoredList[y].equals(singleSentenceToArray[0])==false)
					{
						resultList.add(Arrays.toString(singleSentenceToArray));
						ArrayList<String> currentSentence = new ArrayList<String>(Arrays.asList(singleSentenceToArray));
						currentSentence.add(currentSentence.get(0));
						currentSentence.remove(0);
						currentSentence.toArray(singleSentenceToArray);
						break;
					}
					
				}
			}
			
		}
		
		
		return resultList;
	}
	private String capitalize(String line) {
		   return Character.toUpperCase(line.charAt(0)) + line.substring(1);
		}
}
