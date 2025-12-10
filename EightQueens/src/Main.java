import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        solvePuzzle();
    }

    public static void displayBoard(ArrayList<Queen> queens) {
        for (int y = 7; y >= 0; y--) {

            System.out.print(y+1 + " ");

            for (int x = 0; x < 8; x++) {

                boolean queenHere = false;

                for (int q = 0; q < 8; q++) {
                    if (queens.get(q).getX() == x && queens.get(q).getY() == y) {
                        queenHere = true;
                        break;
                    }

                }

                if (queenHere) System.out.print("[Q]");
                else System.out.print("[ ]");



            }
            System.out.println();
        }

        System.out.println("   A  B  C  D  E  F  G  H");
    }

    public static void solvePuzzle() {
        int tryCounter = 0;
        int validBoardCounter = 0;

        for (int y1 = 0; y1 < 8; y1++) {
            for (int y2 = 0; y2 < 8; y2++) {
                for (int y3 = 0; y3 < 8; y3++) {
                    for (int y4 = 0; y4 < 8; y4++) {
                        for (int y5 = 0; y5 < 8; y5++) {
                            for (int y6 = 0; y6 < 8; y6++) {
                                for (int y7 = 0; y7 < 8; y7++) {
                                    for (int y8 = 0; y8 < 8; y8++) {

                                        ArrayList<Queen> queens = new ArrayList<>();

                                        queens.add(new Queen(0, y1) );
                                        queens.add(new Queen(1, y2) );
                                        queens.add(new Queen(2, y3) );
                                        queens.add(new Queen(3, y4) );
                                        queens.add(new Queen(4, y5) );
                                        queens.add(new Queen(5, y6) );
                                        queens.add(new Queen(6, y7) );
                                        queens.add(new Queen(7, y8) );

                                        tryCounter++;

                                        if (validBoard(queens)) {
                                            System.out.println();
                                            System.out.println("Found valid board!");
                                            validBoardCounter++;
                                            displayBoard(queens);
                                        }

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println();
        System.out.println("Number of boards tested: " + tryCounter);
        System.out.println("Number of valid boards: " + validBoardCounter);
    }

    public static boolean validBoard(ArrayList<Queen> queens) {

        for (int a = 0; a < queens.size(); a++) {
            for (int b = a+1; b < queens.size(); b++) {
                Queen queen1 = queens.get(a);
                Queen queen2 = queens.get(b);

                if( queen1.squareThreatened(queen2) ) return false;

            }
        }

       return true;
    }


}
