package board;
import point.*;
import pieces.*;

public class Board {

	/**
	 * Method which makes the board and assigns each square an appropriate value.
	 * @return the board, a two-dimensional string array
	 */
	public static Point [][] makePoints () {
		Point [][] ptArray = new Point[8][8];
		for (int i = 0; i < ptArray.length; i++) {
			for (int j = 0; j < ptArray.length; j++) {
				ptArray[i][j] = new Point(i,j);
			}
		}
		return ptArray;
	}
	public static Piece [][] makeBoard(Point [][] array) {
		Piece [][] board = new Piece [8][8];

		// Creating the starting position

		// White pieces
		board[0][0] = new Rook(array[0][0], true);
		board[0][1] = new Knight(array[0][1], true);
		board[0][2] = new Bishop(array[0][2], true);
		board[0][3] = new Queen(array[0][3], true);
		board[0][4] = new King(array[0][4], true);
		board[0][5] = new Bishop(array[0][5], true);
		board[0][6] = new Knight(array[0][6], true);
		board[0][7] = new Rook(array[0][7], true);
		for (int i = 0; i < board.length; i++) {
			board[1][i] = new Pawn(array[1][i], true);
		}

		// Black pieces
		board[7][0] = new Rook(array[7][0], false);
		board[7][1] = new Knight(array[7][1], false);
		board[7][2] = new Bishop(array[7][2], false);
		board[7][3] = new Queen(array[7][3], false);
		board[7][4] = new King(array[7][4], false);
		board[7][5] = new Bishop(array[7][5], false);
		board[7][6] = new Knight(array[7][6], false);
		board[7][7] = new Rook(array[7][7], false);
		for (int i = 0; i < board.length; i++) {
			board[6][i] = new Pawn(array[6][i], false);
		}

		return board;
	}
	public static void printBoard(Piece [][] board) {
		for (int i = board.length - 1; i >= 0; i--) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == null) {
					System.out.print("-- ");
				} // End if
				else {
					System.out.print(board[i][j].toString() + " ");
				}
			} // End inner for
			System.out.println();
		} // End outer for
	} // End printBoard
	public static void main(String [] args) {
		Point [][] array = makePoints();
		Piece [][] board = makeBoard(array);
		printBoard(board);
		System.out.println("\n");
		
		if (board[0][0].move(board, new Point(0,5)) == true) {
			board[0][0].setLocation(new Point(0,5));
		}
		printBoard(board);
	}
}
