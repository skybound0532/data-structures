import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This class supplies a utility method to reverse the entries in a linked list.
*/
public class ListUtil
{
    /**
     * Reverses the elements in a linked list
     *
     * @param strings the linked list to reverse
    */
    public static void reverse(LinkedList<String> strings)
    {
        LinkedList<String> newStrings = new LinkedList<>();
        ListIterator<String> iterator = strings.listIterator(strings.size());
        
        while(iterator.hasPrevious())
        {
            newStrings.add(iterator.previous());
        }

        ListIterator<String> iterator1 = newStrings.listIterator();
        
        
        while(iterator.hasNext())
        {
            iterator.next();
            iterator.set(iterator1.next());
        }
    }
}