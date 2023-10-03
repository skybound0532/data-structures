import java.util.PriorityQueue;
import java.util.Queue;


/**
 * This program demonstrates a priority queue of to-do items. The
 * most important to-do items are removed first.
*/
public class PriorityQueueDemo
{
    public static void main(String[] args)
    {
        // Create a toDo list; WorkOrder class has a priority and a description
        Queue<WorkOrder> toDo = new PriorityQueue<>();

        toDo.add(new WorkOrder(3,"Water Plants"));
        toDo.add(new WorkOrder(8,"Make Dinner"));
        toDo.add(new WorkOrder(2,"Commit tax fraud"));
        toDo.add(new WorkOrder(1,"Take over the world"));
        toDo.add(new WorkOrder(5,"Study for Software Engineering"));

        // Objects are not stored in priority order
        System.out.println(toDo);

        // Onjects will be removed in priority order
        while(toDo.size() > 0)
        {
            System.out.println(toDo.remove());
        }
    }
}
