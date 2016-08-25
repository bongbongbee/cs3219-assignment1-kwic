package com.teamfour.pipesandfilters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Alphabetizer {
	
	public Alphabetizer()
	{
	}
	public ArrayList<String> alpha(String[] resultList) {
		 
		ArrayList tempResultList = new ArrayList<String>(Arrays.asList(resultList));
		Collections.sort(tempResultList);
		return caps(tempResultList);
	}
	private ArrayList<String> caps(ArrayList tempResultList) 
	{
		for(int x=0;x<tempResultList.size();x++)
		{
			tempResultList.set(x, capitalize((String) tempResultList.get(x)));
		}
		return tempResultList;
	}

	private String capitalize(String line) {
		   return Character.toUpperCase(line.charAt(0)) + line.substring(1);
		}
}
