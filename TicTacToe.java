import java.util.Scanner;

public class TicTacToe {

    // 2D array to represent the Tic-Tac-Toe grid
    static char[][] grid = {
        {'_', '_', '_'}, 
        {'_', '_', '_'}, 
        {'_', '_', '_'}
    };

    static boolean isOver = false;
    static char currPlayer = 'O';

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while ( (isOver == false) ) {

            displayGrid();
            
            System.out.println("\nPlayer \'" + currPlayer + "\', enter row and column (1-3) respectively:");
            
            int row = sc.nextInt() - 1;
            int col = sc.nextInt() - 1;
            
            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("\nInvalid input, try again.");
                continue;
            }
            if (grid[row][col] != '_') {
                System.out.println("\nPosition already filled, try again.");
                continue;
            }

            // update the value
            grid[row][col] = currPlayer;
            
            if (hasWin()) {
                
                displayGrid();
                System.out.println("\nPlayer \'" + currPlayer + "\' wins!");
                isOver = true;
                break;
            }

            if (isItDraw()) {
                displayGrid();

                System.out.println("\nIt's a draw!");
                isOver = true;
                break;
            }

            currPlayer = (currPlayer == 'O') ? 'X' : 'O';
        }

        sc.close();
    }

    public static void displayGrid() {
        
        // System.out.println(" | | ");
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j]);

                if(j!=2) System.out.print("|");
            }
            System.out.println();
        }
        
        // System.out.println(" | | ");
    }

    public static boolean hasWin() {
        // Check columns
        for (int i = 0; i < 3; i++) {
            if (grid[0][i] == currPlayer && grid[1][i] == currPlayer && grid[2][i] == currPlayer) {
                return true;
            }
        }

        // Check rows
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == currPlayer && grid[i][1] == currPlayer && grid[i][2] == currPlayer) {
                return true;
            }
        }

        // Check diagonals
        if ((grid[0][0] == currPlayer && grid[1][1] == currPlayer && grid[2][2] == currPlayer) || 
            (grid[0][2] == currPlayer && grid[1][1] == currPlayer && grid[2][0] == currPlayer)
           ) {
            return true;
        }

        return false;
    }

    public static boolean isItDraw() {
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == '_') {
                    return false;
                }
            }
        }
        return true;
    }
}    