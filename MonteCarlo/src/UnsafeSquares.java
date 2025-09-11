public class Problem13 {
    public static void main(String[] args) {

    }

    public static void int[][] createBoard(int numQueens) {
        int[][] board = new int[8][8];
        int numQueensPlaced = 0;
        while(numQueensPlaced < numQueens) {
            int x = (int)(Math.random() * 8) + 1;
            int y = (int)(Math.random() * 8) + 1;
            
            if(board[x][y] == 0) {
                board[x][y] = 1;
            }
        }
        
    }


}
