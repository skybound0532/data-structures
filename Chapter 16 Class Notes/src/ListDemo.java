/**
 *   A program that demonstrates the LinkedList class
 */
public class ListDemo
{
    public static void main(String[] args)
    {
        LinkedList students = new LinkedList();
        students.addFirst("Esha");
        students.addFirst("Seth");
        students.addFirst("Celeste");
        students.addFirst("Peter");

        System.out.println(students);
        ListIterator iter = students.listIterator();

        
    }
}
