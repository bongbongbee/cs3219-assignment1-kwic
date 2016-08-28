import java.util.Scanner;

import com.teamfour.implicitinvocations.ImplicitInvocation;
import com.teamfour.pipesandfilters.PipeAndFilter;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please select one architecture to run : ");
        System.out.println("1. Implicit Invocation");
        System.out.println("2. Pipe And Filter");
        System.out.println("\n3. Exit");

        int result = sc.nextInt();
        sc.close();

        if (result != 1 && result != 2) {
            System.exit(0);
        }

        if (result == 1) {
            ImplicitInvocation.run();
        } else if (result == 2) {
            PipeAndFilter.run();
        }
    }
}
