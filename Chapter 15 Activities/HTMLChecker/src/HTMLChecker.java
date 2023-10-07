import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
/**
 * Write a program that checks whether a sequence of HTML tags
 * is properly nested. For each opening tag, such as <p>, there
 * must be a closing tag </p>. A tag such as <p> may have other
 * tags inside, for example <p> <ul> <li> </li> </ul> <a> </a> </p>
 * <p>
 * The inner tags must be closed before the outer ones.
 * Your program should process a file containing tags.
 * For simplicity, assume that the tags are separated by
 * spaces, and that there is no text inside the tags.
*/
public class HTMLChecker
{
    public static void main(String[] args)
    {
        String filename = "Chapter 15 Activities/HTMLChecker/src/TagSample3.html";

        Stack<String> tags = new Stack<>();
        String current;
        String test;
        // ArrayList<String> openTags = new ArrayList<>();

        try (Scanner in = new Scanner(new File(filename)))
        {
            // Your code goes here
            current = getTag(in.next());
            tags.push(current);
            
            while(in.hasNext())
            {
                current = getTag(in.next());

                test = tags.pop();
                if(!current.equals("/" + test))
                {
                    tags.push(test);
                    tags.push(current);
                }
                
            }

            if(tags.size()==0)
            {
                System.out.println("All tags are properly nested.");
            }
            else{
                System.out.println("There are improperly nested tags.");
            }


        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }

    }

    private static String getTag(String in)
    {
        return in.substring(1,in.length()-2);
    }
}
