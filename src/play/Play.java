package play;
import board.*;
import pieces.*;
import point.*;
import java.util.*;
import java.io.*;

public class Play {
	public static void main (String [] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("WELCOME TO SYSTEMS LAB CHESS, VERSION 1.0!");
		System.out.println("Written by Ryan Thomas, with the help of many Systems Lab gurus.");
		System.out.println("Type 'help' for instructions on how to play. \n");
		Board board = Board.getInstance();
		int moveCount = 1;
		Piece selection = null;
		while (true) {
			System.out.println(board);
			if (moveCount % 2 == 1) { // White to move
				System.out.println("White to move.");
			}
			else { // Black to move
				System.out.println("Black to move.");
			}

			System.out.println("Enter your move.");
			String move = kb.nextLine();
			String d1 = "";
			while (!d1.equals("3")) {
				if (move.equalsIgnoreCase("help")) {
					System.out.println("HELP MENU: type a number");
					System.out.println("1. Game input format");
					System.out.println("2. Rules of chess");
					System.out.println("3. Return to game");
					d1 = kb.nextLine();
					if (d1.equals("1")) {
						System.out.println("\nINPUT FORMAT:\n");
						System.out.println("First, enter the square that the piece you would like to move is on.");
						System.out.println("\tSquares should be entered as a rank followed by a file, such as 'a5'");
						System.out.println("Then, enter a space, then the square to which you would like to move that piece.\n");
						System.out.println("EXAMPLE:");
						System.out.println("e2 e4 ----> moves a pawn from e2 to e4\n\n");
					} // end game input format


					else if (d1.equals("2")) {
						System.out.println("RULES OF CHESS: type a number");
						System.out.println("0. General");
						System.out.println("1. Piece movement");
						String d2 = kb.nextLine();
						if (d2.equals("0")) {
							System.out.println("GENERAL \n");
							System.out.println("The objective of chess is to CHECKMATE your opponent's king.");
							System.out.println("CHECK occurs when a player's king is in immediate danger of being captured by an opponent's piece.");
							System.out.println("If your king is in check, you must remove it from check, if possible.");
							System.out.println("CHECKMATE occurs when a player's king is in check and cannot be moved out of check.\n");
						} // end general

						else if (d2.equals("1")) {
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
						} // end piece movement
						else {
							System.out.println("Enter 1 or 2.");
						}
						// end rules
					} // end help
				} // end while

				char piece = move.charAt(0);
				if (piece == 'p' || piece == 'P') {}
				if (piece == 'r' || piece == 'R') {}
				if (piece == 'n' || piece == 'N') {}
				if (piece == 'b' || piece == 'B') {}
				if (piece == 'q' || piece == 'Q') {}
				if (piece == 'k' || piece == 'K') {}

				String square = move.substring(1, 2);
				// Point pt = Board.convertSquareToPoint(square);

			}
			moveCount++;
		} // end while
	} // end main
} // end class
