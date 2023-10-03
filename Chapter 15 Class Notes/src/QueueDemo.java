import java.util.LinkedList;
import java.util.Queue;

/**
 * This program simulates a print queue. Note that documents are printed
 * in the same order as they are submitted.
*/
public class QueueDemo
{
    public static void main(String[] args)
    {
        //Create a print queue of strings (using a linked list)
        Queue<String> jobs = new LinkedList<>();

        // Add some jobs
        jobs.add("Joe: Quarter 2 Expense Report");
        jobs.add("Cathy: Top Secret Document (ur mum)");

        System.out.println("Printing... " + jobs.remove());

        jobs.add("Cathy: Really Top Secreat Document (ur mum!!!)");
        jobs.add("Joe: Grocery List");
        jobs.add("Cathy: Can I Get Fired For This?");
        
        System.out.println("Printing... " + jobs.remove());

        jobs.add("The Boss: Cathy Termination Letter");

        for(int i = 0; i < jobs.size();)
        {
            System.out.println("Printing... " + jobs.remove());
        }
    }
}
