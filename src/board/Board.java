package board;
import java.util.HashMap;

import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;
import point.Point;
import exceptions.InvalidPointException;
import exceptions.NoPieceAtPointException;

public class Board {
	private static int BOARD_SIZE = 8;
	//private Piece [][] board = null;
	public HashMap<Integer, Piece> board;
	
	
	public Board(Piece [][] array) {
		
	}
	public Board() {
		board = new HashMap<Integer, Piece>();
		//board = new Piece[BOARD_SIZE][BOARD_SIZE];
		// White pieces
		board.put(new Point(0, 0).hashCode(), new Rook(new Point(0, 0), true));
		board.put(new Point(1, 0).hashCode(), new Knight(new Point(1, 0), true));
		board.put(new Point(2, 0).hashCode(), new Bishop(new Point(2, 0), true));
		board.put(new Point(3, 0).hashCode(), new Queen(new Point(3, 0), true));
		board.put(new Point(4, 0).hashCode(), new King(new Point(4, 0), true));
		board.put(new Point(5, 0).hashCode(), new Bishop(new Point(5, 0), true));
		board.put(new Point(6, 0).hashCode(), new Knight(new Point(6, 0), true));
		board.put(new Point(7, 0).hashCode(), new Rook(new Point(7, 0), true));
		/*for (int i = 0; i < BOARD_SIZE; i++) {
			board.put(new Point(i, 1).hashCode(), new Pawn(new Point(i, 1), true));
		}*/

		// Black pieces
		/*
		board[7][0] = new Rook(new Point(7, 0), false);
		board[7][1] = new Knight(new Point(7, 1), false);
		board[7][2] = new Bishop(new Point(7, 2), false);
		board[7][3] = new Queen(new Point(7, 3), false);
		board[7][4] = new King(new Point(7, 4), false);
		board[7][5] = new Bishop(new Point(7, 5), false);
		board[7][6] = new Knight(new Point(7, 6), false);
		board[7][7] = new Rook(new Point(7, 7), false);
		for (int i = 0; i < board.length; i++) {
			board[6][i] = new Pawn(new Point(6, i), false);
		}
		*/
		board.put(new Point(0, 7).hashCode(), new Rook(new Point(0, 7), false));
		board.put(new Point(1, 7).hashCode(), new Knight(new Point(1, 7), false));
		board.put(new Point(2, 7).hashCode(), new Bishop(new Point(2, 7), false));
		board.put(new Point(3, 7).hashCode(), new Queen(new Point(3, 7), false));
		board.put(new Point(4, 7).hashCode(), new King(new Point(4, 7), false));
		board.put(new Point(5, 7).hashCode(), new Bishop(new Point(5, 7), false));
		board.put(new Point(6, 7).hashCode(), new Knight(new Point(6, 7), false));
		board.put(new Point(7, 7).hashCode(), new Rook(new Point(7, 7), false));
		for (int i = 0; i < BOARD_SIZE; i++) {
			board.put(new Point(i, 6).hashCode(), new Pawn(new Point(i, 6), false));
		}
	}
	
	private Piece pieceAtPoint(Point p) {
		return board.get(p.hashCode());
		//return board[p.getX()][p.getY()];
	}
	
	private void setPieceAtPoint(Point p, Piece piece) {
		//board[p.getX()][p.getY()] = piece;
		board.put(p.hashCode(), piece);
	}
	
	public boolean move(Point src, Point dst) {
		Piece sourcePiece = pieceAtPoint(src);
		if (sourcePiece.canMove(this, dst)) {
			// update board in Board
			setPieceAtPoint(dst, sourcePiece);
			setPieceAtPoint(src, null);
			
			// update piece location
			sourcePiece.setLocation(dst);
			
			return true;
		} else {
			// could not move
			System.out.println("Board: can't move");
			return false;
		}
	}
	
	private boolean isInValidPoint(Point pt) {
		return (pt.getX() < 0) || (pt.getX() >= BOARD_SIZE) || (pt.getY() < 0) || (pt.getY() >= BOARD_SIZE);
	}
	
	public boolean thereIsPiece(Point pt) throws InvalidPointException {
		if (isInValidPoint(pt)) {
			throw new InvalidPointException();
		}
		if (board.get(pt.hashCode()) != null) {
			return true;
		}
		else return false;
	}
	
	public boolean isWhite(Point pt) throws InvalidPointException, NoPieceAtPointException {
		
		if (!thereIsPiece(pt)) {
			throw new NoPieceAtPointException();
		}
		
		if (board.get(pt.hashCode()).isWhite() == true) {
			return true;
		}
		else return false;
	}

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
	
	public String toString() {
		String s = "";
		for (int i = BOARD_SIZE - 1; i >= 0; i--) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				if (board.get(new Point(j, i).hashCode()) == null) {
					s += "-- ";
				} // End if
				else {
					s += board.get(new Point(j, i).hashCode()) + " ";
				}
			} // End inner for
			s += "\n";
		} // End outer for
		return s;
	}
	
	public static void main(String [] args) {
		Board board = new Board();
		System.out.println(board);
		
		Point sourcePoint = new Point(0, 0);
		
		Point dstPoint = new Point(0, 3);
		System.out.println(board.move(sourcePoint, dstPoint));
		System.out.println(board);
		System.out.println(board.move(dstPoint, new Point(5, 3)));
		System.out.println(board);
		System.out.println(board.move(new Point(5, 3), new Point(5, 6)));
		System.out.println(board);
		System.out.println(board.move(new Point(5, 6), new Point(7, 7)));
		System.out.println(board);
		System.out.println(board.move(new Point(5, 6), new Point(5, 0)));
		System.out.println(board);
	}
}
