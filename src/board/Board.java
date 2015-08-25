package board;
import java.util.*;
import pieces.*;
import point.*;
import exceptions.*;

public class Board {
	
	private static Board singletonBoard;
	private static int BOARD_SIZE = 8;
	public HashMap<Integer, Piece> board;
	
	private Board() {
		board = new HashMap<Integer, Piece>();

		// White pieces
		board.put(new Point(0, 0).hashCode(), new Rook(new Point(0, 0), true));
		board.put(new Point(1, 0).hashCode(), new Knight(new Point(1, 0), true));
		board.put(new Point(2, 0).hashCode(), new Bishop(new Point(2, 0), true));
		board.put(new Point(3, 0).hashCode(), new Queen(new Point(3, 0), true));
		board.put(new Point(4, 0).hashCode(), new King(new Point(4, 0), true));
		board.put(new Point(5, 0).hashCode(), new Bishop(new Point(5, 0), true));
		board.put(new Point(6, 0).hashCode(), new Knight(new Point(6, 0), true));
		board.put(new Point(7, 0).hashCode(), new Rook(new Point(7, 0), true));
		for (int i = 0; i < BOARD_SIZE; i++) {
			board.put(new Point(i, 1).hashCode(), new Pawn(new Point(i, 1), true));
		}

		// Black pieces
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
	
	public static Board getInstance() {
		if (singletonBoard == null) {
			singletonBoard = new Board();
		}
		
		return singletonBoard;
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
		if (isInvalidPoint(dst)) {
			return false;
		}
		
		Piece sourcePiece = pieceAtPoint(src);
		if (sourcePiece.canMove(dst)) {
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
	} // end move
	
	public static Point convertSquareToPoint(String square) {
		int x = -1;
		int y = -1;
		char rank, file;
		
		file = square.charAt(0);
		if (file == 'a') x = 0;
		if (file == 'b') x = 1;
		if (file == 'c') x = 2;
		if (file == 'd') x = 3;
		if (file == 'e') x = 4;
		if (file == 'f') x = 5;
		if (file == 'g') x = 6;
		if (file == 'h') x = 7;
		
		rank = square.charAt(1);
		if (rank == '1') y = 0;
		if (rank == '2') y = 1;
		if (rank == '3') y = 2;
		if (rank == '4') y = 3;
		if (rank == '5') y = 4;
		if (rank == '6') y = 5;
		if (rank == '7') y = 6;
		if (rank == '8') y = 7;
		
		return new Point(x,y);
	} // end convertSquareToPoint
	
	public boolean isInvalidPoint(Point pt) {
		return (pt.getX() < 0) || (pt.getX() >= BOARD_SIZE) || (pt.getY() < 0) || (pt.getY() >= BOARD_SIZE);
	}
	
	public boolean thereIsPiece(Point pt) throws InvalidPointException {
		if (isInvalidPoint(pt)) {
			throw new InvalidPointException();
		}
		if (board.get(pt.hashCode()) != null) {
			return true;
		}
		else return false;
	} // end thereIsPiece
	
	public boolean isWhite(Point pt) throws InvalidPointException, NoPieceAtPointException {
		
		if (!thereIsPiece(pt)) {
			throw new NoPieceAtPointException();
		}
		
		if (board.get(pt.hashCode()).isWhite() == true) {
			return true;
		}
		else return false;
	} // end isWhite
	
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
	} // end toString
	
	public static void main(String [] args) {
		Board board = Board.getInstance();
		System.out.println(board);
	} // end main
} // end class
