package com.teamfour.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteToFile {

    private WriteToFile() {

    }

    public static void writeToFile(ArrayList<String> listContent) throws IOException {
    	File file = new File("output.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		for(int x=0;x<listContent.size();x++)
		{
			bw.write(listContent.get(x));
		}
		bw.close();
    }

}
