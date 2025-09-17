public class UnsafeSquares {
    public static void main(String[] args) {

    }

    public static int[][] createBoard(int numQueens) {
        int[][] board = new int[8][8];
        int numQueensPlaced = 0;
        while(numQueensPlaced < numQueens) {

            int x = (int)(Math.random() * 8);
            int y = (int)(Math.random() * 8);

            if(board[x][y] == 0) {
                board[x][y] = 1;
                numQueensPlaced++;
            }

        }

        return board;
    }

    public static int numSquaresSafe(int numQueens) {
        int[][] board = createBoard(numQueens);
        return 1;
    }


}
