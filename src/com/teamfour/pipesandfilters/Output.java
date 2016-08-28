package com.teamfour.pipesandfilters;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Output extends Filter {

	public Output(Pipe input, Pipe output) {
		super(input, null);
	}
	

	@Override
	protected void transform() {
		try {
			int k = input_.readInput();
						
			File file = new File("output.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			for(int x=0;x<input_.readResultList().length;x++)
			{
				System.out.print(input_.readResultList()[x]);
				bw.write(input_.readResultList()[x]);
				
				if(x<input_.readResultList().length-1)
				{
					System.out.println();
					bw.write("\n");
				}
			}
			bw.close();
	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}




}
