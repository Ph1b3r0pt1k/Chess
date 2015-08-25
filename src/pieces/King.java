package pieces;
import point.Point;
import exceptions.*;

public class King extends Piece {
	public King(Point location, boolean isWhite) {
		this.location = location;
		this.isWhite = isWhite;
	}
	public boolean canMove(Point dst) {
		try {
			if (Math.abs(location.getX() - dst.getX()) <= 1 && Math.abs(location.getY() - dst.getY()) <= 1) {
				return !isFriendly(dst);
			}
			else {
				System.out.println("Invalid move.");
				return false;
			}
		} catch (NoPieceAtPointException e) {
			return true;
		} catch (InvalidPointException e) {
			System.out.println("Invalid point exception.");
			return false;
		}
	} // End move

	public String toString() {
		if (isWhite == true) {
			return "WK";
		}
		else {
			return "BK";
		}
	} // End toString
} // End class
