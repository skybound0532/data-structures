import java.util.Stack;

public class Grid
{
    private static final int SIZE = 10;
    int[][] pixels = new int[SIZE][SIZE];
    Stack<Pair> cords = new Stack<>();
    Pair current;
    int count;

    /**
     * Flood fill, starting with the given row and column.
    */
    public void floodfill(int row, int column)
    {
        cords.push(new Pair(row,column));
        count = 1;

        while(!cords.isEmpty())
        {
            current=cords.pop();
            if(current.row() < SIZE && current.col() < SIZE && current.row() >= 0 && current.col() >= 0 && pixels[current.row()][current.col()] == 0)
            {
                pixels[current.row()][current.col()] = count;
                count ++;
                
                cords.push(new Pair(current.row() - 1,current.col()));
                cords.push(new Pair(current.row(),current.col() + 1));
                cords.push(new Pair(current.row() + 1,current.col()));
                cords.push(new Pair(current.row(),current.col() - 1));
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
