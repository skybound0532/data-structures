import java.util.*;
import java.io.*;
/**
 * Read all words from a file and add them to a map
 * whose keys are the first letters of the words and
 * whose values are sets of words that start with
 * that same letter.
 * Then print out the word sets in alphabetical order.
 * Use the Java 8 merge() feature.
*/
public class FirstLetterMap
{
    public static void main(String[] args)
    {
        String filename = "Chapter 15 Activities/FirstLetterMap/FirstLetterMap1/src/test1.txt";

        try (Scanner in = new Scanner(new File(filename)))
        {

            // Create your map here
            Map<Character,Set<String>> words = new TreeMap<>();

            while (in.hasNext())
            {
                String word = clean(in.next());
                Character c = word.charAt(0);

                // Update the map here
                // Use the Java 8 merge method
                /*
                Set<String> wordsPlus = new TreeSet<>();
                wordsPlus.add(word);
                
                if(words.get(c)!=null)
                {
                    words.get(c).add(word);
                }
                
                words.merge(c, wordsPlus, (old, newVal) -> old);
                */

                words.merge(c,
                new TreeSet<>(Arrays.asList(word)),
                (oldValue, newValue) -> 
                    {
                        oldValue.add(newValue);
                        return oldValue;
                    }
                );

            }

            // Print the map here in this form
            // a: [a, able, aardvark]
            Set<Character> keys = words.keySet();

            for(Character key : keys)
            {
                System.out.println(key + ": " + words.get(key));
            }

        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }
    }

    public static String clean(String s)
    {
        String r = "";
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (Character.isLetter(c))
            {
                r = r + c;
            }
        }
        return r.toLowerCase();
    }

}
