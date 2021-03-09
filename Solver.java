import java.util.Scanner;

public class Solver {

    public static void main(String[] args)
    {
        int[][] grid = new int[9][9];
        Input(grid);
        if (solveSudoku(grid, 0, 0))
            print(grid);
        else
            System.out.println("No Solution exists");
    }

    static boolean solveSudoku(int[][] grid, int row, int col)
    {
        if (row == 9 - 1 && col == 9)
            return true;
        if (col == 9) {
            row++;
            col = 0;
        }
        if (grid[row][col] != 0)
            return solveSudoku(grid, row, col + 1);
        for (int num = 1; num < 10; num++)
        {
            if (check(grid, row, col, num))
            {
                grid[row][col] = num;
                if (solveSudoku(grid, row, col + 1))
                    return true;
            }
            grid[row][col] = 0;
        }
        return false;
    }

    static void print(int[][] grid)
    {
        System.out.println("\n");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                System.out.print(grid[i][j] + " ");
            System.out.println();
        }
    }

    static boolean check(int[][] grid, int row, int col, int num)
    {

        for (int x = 0; x <= 8; x++)
            if (grid[row][x] == num)
                return false;

        for (int x = 0; x <= 8; x++)
            if (grid[x][col] == num)
                return false;

        int startRow = row - row % 3, startCol = col - col % 3;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (grid[i + startRow][j + startCol] == num)
                    return false;

        return true;
    }

    public static void Input (int[][] Board)
    {
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<9;i++)
        {
            for(int j=0; j<9;j++)
            {
                Board[i][j]=sc.nextInt();
            }
        }
    }

}


/*

8 0 0 0 0 0 0 0 0
0 0 3 6 0 0 0 0 0
0 7 0 0 9 0 2 0 0
0 5 0 0 0 7 0 0 0
0 0 0 0 4 5 7 0 0
0 0 0 1 0 0 0 3 0
0 0 1 0 0 0 0 6 8
0 0 8 5 0 0 0 1 0
0 9 0 0 0 0 4 0 0


 */