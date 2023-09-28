import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
/**
 * A program to add, remove, modify or print
 * student names and grades.
*/
public class Gradebook
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        Map<String, String> grades = new HashMap<>();

        String name;
        String grade;

        boolean done = false;
        while(!done)
        {
            System.out.println("A)dd R)emove M)odify P)rint Q)uit");
            String input = in.next().toUpperCase();
            
            in.nextLine();

            if (input.equals("Q"))
            {
                done = true;
            } else if (input.equals("A"))
            {
                
                System.out.print("Please enter the name: ");
                name = in.nextLine();

                System.out.print("Please enter grade: ");
                grade = in.nextLine().toUpperCase();

                grades.put(name, grade);

            } else if (input.equals("R"))
            {
                System.out.print("Please enter the name: ");
                
                grades.remove(in.nextLine());

            } else if (input.equals("M"))
            {
                System.out.print("Please enter the name: ");
                name = in.nextLine();

                System.out.print("Please enter grade: ");
                grade = in.nextLine().toUpperCase();

                grades.put(name, grade);

            } else if (input.equalsIgnoreCase("P"))
            {
                Set<String> names = grades.keySet();

                for(String n : names)
                {
                    System.out.println(n + " " + grades.get(n));
                }

            } else
            {
                done = true;
            }
        }
    }
}
