package com.teamfour.pipesandfilters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PipeAndFilter {
	
	public static void run ()
	{
		Input input = new Input();
		String[] tempIgnoredList = input.fetchIgnoredList();
		String[] tempSentenceList = input.fetchSentenceList();
		

		
		
		CircularShift cs = new CircularShift();
		Alphabetizer alphaObj = new Alphabetizer();
		Output output = new Output();
		ArrayList<String> circularList = cs.fetchCircularList(performDeepCopyArray(tempIgnoredList),performDeepCopyArray(tempSentenceList));
		String[] tempResultList =performDeepCopyArrayList(alphaObj.alpha(performDeepCopyArrayList(circularList)));
		

		output.displayResult(tempResultList);

	}

	private static void printTheList(ArrayList<String> list) {
		for(int x=0;x<list.size();x++)
		{
			System.out.println(list.get(x));
		}		
	}

	private static String[] performDeepCopyArray(String[] tempList) {
		String[] newList = new String[tempList.length];
		for(int x=0;x<tempList.length;x++)
		{
			newList[x] = tempList[x];
		}		
		return newList;
	}
	private static String[] performDeepCopyArrayList(ArrayList<String> tempList) {
		String[] newList = new String[tempList.size()];
		for(int x=0;x<tempList.size();x++)
		{
			newList[x] = tempList.get(x);
		}		
		return newList;
	}






}
