package com.teamfour.utilities;

import java.util.Comparator;

public final class AlphabeticalOrder {
	 private AlphabeticalOrder() {

	   }

	 public static Comparator<String> ALPHABETICAL_ORDER = new Comparator<String>() {
		    public int compare(String str1, String str2) {
		        int x = String.CASE_INSENSITIVE_ORDER.compare(str1, str2);
		        if (x == 0) {
		            x = str1.compareTo(str2);
		        }
		        return x;
		    }
		};
}
