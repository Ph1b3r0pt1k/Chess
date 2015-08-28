package play;
import board.*;
import point.*;
import java.util.*;

public class Play {
	public static void main (String [] args) {
		Scanner kb = new Scanner(System.in);
		showIntroTitles();
		
		Board board = Board.getInstance();
		int moveCount = 1;
		
		while (true) {
			System.out.println(board);
			promptMove(moveCount);
			String input = kb.nextLine();
			System.out.println();
			
			if (input.equalsIgnoreCase("help")) helpMenu(kb);
			String startingSquare = input.substring(0, 2);
			String endingSquare = input.substring(3, 5);
			
			Point startingPt = board.convertSquareToPoint(startingSquare);
			Point endingPt = board.convertSquareToPoint(endingSquare);
			
			if (board.move(startingPt, endingPt)) moveCount++;
		}
	}
	
	private static void helpMenu(Scanner kb) {
		showHelpMenu();

		String d1 = kb.nextLine();
		if (d1.equals("1")) showGameInputFormat();
		else if (d1.equals("2")) {
			showSubHelpMenu();

			String d2 = kb.nextLine();
			if (d2.equals("0")) showGeneralHelpInfo();
			else if (d2.equals("1")) showPieceMovementHelpInfo();
			else System.out.println("Enter 1 or 2.");
		} 
	}

	private static void showHelpMenu() {
		System.out.println("HELP MENU: type a number");
		System.out.println("1. Game input format");
		System.out.println("2. Rules of chess");
		System.out.println("3. Return to game");
	}

	private static void showSubHelpMenu() {
		System.out.println("RULES OF CHESS: type a number");
		System.out.println("0. General");
		System.out.println("1. Piece movement");
	}

	private static void showPieceMovementHelpInfo() {
		System.out.println("PIECE MOVEMENT \n");
		System.out.println("The PAWN can only move forward.");
		System.out.println("If it is a pawn's first move, it can move forward one or two squares.");
		System.out.println("After it's first move, it can only move forward one square.");
		System.out.println("Pawns can only capture by moving one square diagonally forward.\n");
		System.out.println("The KNIGHT moves in an L-shape; it moves 2 squares up or down, and one square over.");
		System.out.println("Knights can also jump over pieces, friendly or enemy.\n");
		System.out.println("The ROOK can move as far as desired, in a straight line.\n");
		System.out.println("The BISHOP can move as far as desired, but only on a diagonal.\n");
		System.out.println("The QUEEN combines the power of the rook and the bishop.");
		System.out.println("Queens can move as far as desired in a straight line or on a diagonal.\n");
		System.out.println("The KING can move only one square in any direction.\n");
		System.out.println("This program uses the following symbols to represent pieces:");
		System.out.println("W = white");
		System.out.println("B = black");
		System.out.println("P = pawn");
		System.out.println("R = rook");
		System.out.println("N = knight");
		System.out.println("B = bishop");
		System.out.println("Q = queen");
		System.out.println("K = king");
	}

	private static void showGeneralHelpInfo() {
		System.out.println("GENERAL \n");
		System.out.println("The objective of chess is to CHECKMATE your opponent's king.");
		System.out.println("CHECK occurs when a player's king is in immediate danger of being captured by an opponent's piece.");
		System.out.println("If your king is in check, you must remove it from check, if possible.");
		System.out.println("CHECKMATE occurs when a player's king is in check and cannot be moved out of check.\n");
	}

	private static void showGameInputFormat() {
		System.out.println("\nINPUT FORMAT:\n");
		System.out.println("First, enter the square that the piece you would like to move is on.");
		System.out.println("\tSquares should be entered as a rank followed by a file, such as 'a5'");
		System.out.println("Then, enter a space, then the square to which you would like to move that piece.\n");
		System.out.println("EXAMPLE:");
		System.out.println("e2 e4 ----> moves a pawn from e2 to e4\n\n");
	}
	
	private static void showIntroTitles() {
		System.out.println("WELCOME TO GASDAY CHESS, VERSION 1.0!");
		System.out.println("Written by Jim Reilly and Ryan Thomas.");
		System.out.println("Type 'help' for instructions on how to play. \n");
	}
	
	private static void promptMove(int moveCount) {
		if (moveCount % 2 == 1) {
			System.out.println("White to move.");
		}
		else {
			System.out.println("Black to move.");
		}
		System.out.println("Enter your move.");
	}
}
