package com.teamfour.pipesandfilters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Input{
	
	Scanner sc;
	public Input()
	{
		sc  = new Scanner(System.in);
	}
	
	public String[] fetchIgnoredList() {
		final String MESSAGE1 = "Enter Ignored Words: ";
		final String comma = ",";
		System.out.println(MESSAGE1);
		String manySentence = sc.nextLine();
		manySentence= manySentence.toLowerCase();
		String[] stringArraySentences = manySentence.split(comma);
		for(int x=0;x<stringArraySentences.length;x++)
		{
			if(stringArraySentences[x].startsWith(" "))
			{
				stringArraySentences[x] = stringArraySentences[x].substring(1);
			}
			//System.out.println(stringArraySentences[x]);
		}
		return stringArraySentences;	
	}

	public String[] fetchSentenceList() {
		final String MESSAGE1 = "Enter Setence: ";
		final String comma = ",";
		System.out.println(MESSAGE1);
		String manySentence = sc.next();
		manySentence+= sc.nextLine();
		//manySentence= manySentence.toLowerCase();

		String[] stringArraySentences = manySentence.split(comma);
		for(int x=0;x<stringArraySentences.length;x++)
		{
			if(stringArraySentences[x].startsWith(" "))
			{
				stringArraySentences[x] = stringArraySentences[x].substring(1);
			}
			//System.out.println(stringArraySentences[x]);
		}
		
		return stringArraySentences;		
	}

	
	
	

	

	
}
