import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TicTacToe {

	public static void main(String[] args) {
		
		// Variable building and initialization. And making instances.
		char[][] boardArray = {{' ', '|', ' ', '|', ' '},
				{'-', '+', '-', '+', '-'},
				{' ', '|', ' ', '|', ' '},
				{'-', '+', '-', '+', '-'},
				{' ', '|', ' ', '|', ' '}};
		ArrayList<Integer> unusedCells = new ArrayList<>();
		ArrayList<Integer> usedCells = new ArrayList<>();
		for(int i = 1; i < 10; i++) {
			unusedCells.add(i);
		}
		AppHelper tic = new AppHelper();
		boolean play = true;
		int coord = 0;
		int coord_comp;
		int winman = 9;
		int length;
		int choice;
		//

		// Game introduction.
		System.out.println("This is game of Tic-Tac-toe. You will play it against computer (or AI).");
		System.out.println("Board and cells will be as follows:-");
		System.out.println("1|2|3\n-+-+-\n4|5|6\n-+-+-\n7|8|9\n");
		System.out.println("You will put X. Computer will put O.");
		//
		
		// Main code
		while (play) {

			if (play) {

				do {
					try {
						coord = tic.getUserInputInt();
						System.out.println(coord);
						if (usedCells.contains(coord)) {
							System.out.println(
									"Invalid move: Space already occupied or number not from 1-9. Input again.");
						}
					} catch (Exception ex) {
						System.err.println("Invalid move: Entry not an integer!");
					}
				} while (usedCells.contains(coord));

				usedCells.add(coord);
				unusedCells.remove((Integer) coord);

				if (coord == 1) {
					boardArray[0][0] = 'X';
				} else if (coord == 2) {
					boardArray[0][2] = 'X';
				} else if (coord == 3) {
					boardArray[0][4] = 'X';
				} else if (coord == 4) {
					boardArray[2][0] = 'X';
				} else if (coord == 5) {
					boardArray[2][2] = 'X';
				} else if (coord == 6) {
					boardArray[2][4] = 'X';
				} else if (coord == 7) {
					boardArray[4][0] = 'X';
				} else if (coord == 8) {
					boardArray[4][2] = 'X';
				} else if (coord == 9) {
					boardArray[4][4] = 'X';
				} else {
					System.out.println("Program error! Player turn override!");
				}
				if (tic.checkWin_X(boardArray) == 1) {
					play = false;
					winman = 0;
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (play) {

				do {
					length = unusedCells.size();
					choice = (int) (Math.random() * length);
					coord_comp = unusedCells.get(choice);
				} while (usedCells.contains(coord_comp) && tic.checkBoard(boardArray) == 0);

				usedCells.add(coord_comp);
				unusedCells.remove((Integer) coord_comp);

				if (coord_comp == 1) {
					boardArray[0][0] = 'O';
				} else if (coord_comp == 2) {
					boardArray[0][2] = 'O';
				} else if (coord_comp == 3) {
					boardArray[0][4] = 'O';
				} else if (coord_comp == 4) {
					boardArray[2][0] = 'O';
				} else if (coord_comp == 5) {
					boardArray[2][2] = 'O';
				} else if (coord_comp == 6) {
					boardArray[2][4] = 'O';
				} else if (coord_comp == 7) {
					boardArray[4][0] = 'O';
				} else if (coord_comp == 8) {
					boardArray[4][2] = 'O';
				} else if (coord_comp == 9) {
					boardArray[4][4] = 'O';
				} else {
					System.out.println("Program error! Computer turn override!");
				}
				System.out.println("Computer puts O on cell " + coord_comp + ".");
				if (tic.checkWin_O(boardArray) == 1) {
					play = false;
					winman = 1;
				}
			}
			tic.printBoard(boardArray);
			if (winman == 0) {
				System.out.println("You won the game.");
			} else if (winman == 1) {
				System.out.println("Computer won the game.");
			} else if (tic.checkBoard(boardArray) == 1) {
				System.out.println("It's a cat's game! (A tie)");
			}
		}
		//
	}
}

class AppHelper {
    // Modules helping the program.
    void printBoard(char[][] boardArray1) {

        char[] boardCurrent1;
		for (char[] chars : boardArray1) {
			boardCurrent1 = chars;
			for (char c : boardCurrent1) {
				System.out.print(c);
			}
			System.out.println();
		}
    }

    int checkWin_X(char[][] boardArray3) {

        int valX = 0;

        if (boardArray3[0][0] == 'X' & boardArray3[0][2] == 'X' & boardArray3[0][4] == 'X') valX = 1;
        if (boardArray3[2][0] == 'X' & boardArray3[2][2] == 'X' & boardArray3[2][4] == 'X') valX = 1;
        if (boardArray3[4][0] == 'X' & boardArray3[4][2] == 'X' & boardArray3[4][4] == 'X') valX = 1;
        if (boardArray3[0][0] == 'X' & boardArray3[2][0] == 'X' & boardArray3[4][0] == 'X') valX = 1;
        if (boardArray3[0][2] == 'X' & boardArray3[2][2] == 'X' & boardArray3[4][2] == 'X') valX = 1;
        if (boardArray3[0][4] == 'X' & boardArray3[2][4] == 'X' & boardArray3[4][4] == 'X') valX = 1;
        if (boardArray3[0][0] == 'X' & boardArray3[2][2] == 'X' & boardArray3[4][4] == 'X') valX = 1;
        if (boardArray3[0][4] == 'X' & boardArray3[2][2] == 'X' & boardArray3[4][0] == 'X') valX = 1;

        return valX;
    }

    int checkWin_O(char[][] boardArray4) {

        int valO = 0;

        if (boardArray4[0][0] == 'O' & boardArray4[0][2] == 'O' & boardArray4[0][4] == 'O') valO = 1;
        if (boardArray4[2][0] == 'O' & boardArray4[2][2] == 'O' & boardArray4[2][4] == 'O') valO = 1;
        if (boardArray4[4][0] == 'O' & boardArray4[4][2] == 'O' & boardArray4[4][4] == 'O') valO = 1;
        if (boardArray4[0][0] == 'O' & boardArray4[2][0] == 'O' & boardArray4[4][0] == 'O') valO = 1;
        if (boardArray4[0][2] == 'O' & boardArray4[2][2] == 'O' & boardArray4[4][2] == 'O') valO = 1;
        if (boardArray4[0][4] == 'O' & boardArray4[2][4] == 'O' & boardArray4[4][4] == 'O') valO = 1;
        if (boardArray4[0][0] == 'O' & boardArray4[2][2] == 'O' & boardArray4[4][4] == 'O') valO = 1;
        if (boardArray4[0][4] == 'O' & boardArray4[2][2] == 'O' & boardArray4[4][0] == 'O') valO = 1;

        return valO;
    }

    int getUserInputInt() {
        int inputLine = 0;
        System.out.print("Enter your cell number (1-9): ");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = Integer.parseInt(is.readLine());
            if (inputLine == 0 )  {
                return 0;
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }

        return inputLine;
    }

    int checkBoard(char[][] boardArray5) {

        int full = 0;
        if (boardArray5[0][0] != ' ' &&
				boardArray5[0][2] != ' ' &&
				boardArray5[0][4] != ' ' &&
				boardArray5[2][0] != ' ' &&
				boardArray5[2][2] != ' ' &&
				boardArray5[2][4] != ' ' &&
				boardArray5[4][0] != ' ' &&
				boardArray5[4][2] != ' ' &&
				boardArray5[4][4] != ' ') full = 1;
        return full;
    }
    //
}
