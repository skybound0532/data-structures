

import java.util.*;

public class Grid
{
    private static final int SIZE = 10;
    int[][] pixels = new int[SIZE][SIZE];
    Stack<Pair> theStack;
    int count;

    /**
     * Flood fill, starting with the given row and column.
    */
    public void floodfill(int row, int column)
    {
        theStack = new Stack<>();
        theStack.push(new Pair(row, column));
        count = 1;
        Pair current;

        while(!theStack.isEmpty())
        {
            current = theStack.pop();
            if(current.getRow() >= 0 && current.getCol() >= 0 && current.getRow() < 10 && current.getCol() < 10 && pixels[current.getRow()][current.getCol()] != 0)
            {
                pixels[current.getRow()][current.getCol()] = count;
                count++;
                theStack.push(new Pair(current.getRow()-1,current.getCol()));
                theStack.push(new Pair(current.getRow(),current.getCol()-1));
                theStack.push(new Pair(current.getRow()+1,current.getCol()));
                theStack.push(new Pair(current.getRow(),current.getCol()+1));
            }
        }
            
        
    }

    @Override
    public String toString()
    {
        String r = "";
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
                r = r + String.format("%4d", pixels[i][j]);
            r = r + "\n";
        }
        return r;
    }
}
