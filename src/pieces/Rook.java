package pieces;
import point.*;

public class Rook extends Piece {
	public Rook(Point location, boolean isWhite) {
		this.location = location;
		this.isWhite = isWhite;
	} // end constructor
	public boolean move(Piece [][] board, Point dst) {
		int src_x = location.getX();
		int src_y = location.getY();
		int dst_x = dst.getX();
		int dst_y = dst.getY();

		// The x's are the same, so the move is vertical
		if (src_x == dst_x) {
			int j = (src_x - dst_x > 0) ? 1: -1;
			for (int i = src_x; i != dst_x; i += j) {
				if (board[i][src_y] == null) {
					// Keep going
				}
				else {
					System.out.println("Invalid move.");
					return false;
				}
			}
			if (this.isWhite()) {
				return !board[dst_x][dst_y].isWhite();
			}
			else {
				return board[dst_x][dst_y].isWhite();
			}
		}

		// The y's are the same, so the move is horizontal
		else if (src_y == dst_y) {
			int j = (src_y - dst_y > 0) ? 1: -1;
			for (int i = src_y; i != dst_y; i += j) {
				if (board[src_x][i] == null) {
					// keep going
				}
				else {
					return false;
				}
			}
			if (this.isWhite()) {
				return !board[dst_x][dst_y].isWhite();
			}
			else {
				return board[dst_x][dst_y].isWhite();
			}
		}


		else { // Invalid move
			System.out.println("Invalid move.");
			return false;
		}

	} // end move
	public String toString() {
		if (isWhite == true) {
			return "WR";
		}
		else {
			return "BR";
		}

	} // End toString
} // end class
