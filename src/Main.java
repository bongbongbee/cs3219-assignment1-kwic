import java.util.Scanner;

import com.teamfour.pipesandfilters.PipeAndFilter;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please select one architecture to run : ");
		System.out.println("1 Implicit Invocation");
		System.out.println("2 Pipe And Filter");
		System.out.println("EXIT by keying any other keys");
		while(true)
		{
			int result = sc.nextInt();
			if(result==1)
			{
				//ImplicitInvocation.run();
			}
			else if(result ==2)
			{
				PipeAndFilter.run();
			}
			else
			{
				System.exit(0);
			}
		}
		
	
	}
}
