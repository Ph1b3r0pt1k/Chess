package pieces;
import point.*;
import board.*;
import exceptions.*;

public class Rook extends Piece {
	public Rook(Point location, boolean isWhite) {
		this.location = location;
		this.isWhite = isWhite;
	} // end constructor
	public boolean canMove(Point dst) {
		int src_x = location.getX();
		int src_y = location.getY();
		int dst_x = dst.getX();
		int dst_y = dst.getY();

		try {
			// The x's are the same, so the move is horizontally 
			if (src_y == dst_y) {
				int j = (src_x - dst_x > 0) ? -1: 1;
				
				for (int i = src_x + j; i != dst_x; i += j) {
					if (!Board.getInstance().thereIsPiece(new Point(i, src_y))) {
						// keep going
					} else {
						System.out.println("Invalid move.");
						return false;
					}
				} // end for
				
				if (isFriendly(dst)) {
					return false;
				} else {
					return true;
				}
			}
	
			// The y's are the same, so the move is vertical
			else if (src_x == dst_x) {
				int j = (src_y - dst_y > 0) ? -1: 1;
				
				for (int i = src_y + j; i != dst_y; i += j) {
					if (!Board.getInstance().thereIsPiece(new Point(src_x, i))) {
						// keep going
					}
					else {
						System.out.println("Invalid move.");
						return false;
					}
				}

				if (isFriendly(dst)) {
					return false;
				} else {
					return true;
				}
			}
	
	
			else {
				return false;
			}
		} catch (InvalidPointException e) {
			System.out.println("Can't move. Invalid point exception.");
			return false;
		} catch (NoPieceAtPointException e) {
			return true;
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
