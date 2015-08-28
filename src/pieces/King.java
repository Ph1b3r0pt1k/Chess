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
			if (moveIsOneSquare(dst)) {
				return !isFriendly(dst);
			}
			else {
				System.out.println("Invalid move.");
				return false;
			}
		} catch (NoPieceAtPointException e) {
			return true;
		} catch (InvalidPointException e) {
			return false;
		}
	}
	
	private boolean moveIsOneSquare(Point dst) {
		return Math.abs(location.getX() - dst.getX()) <= 1 && Math.abs(location.getY() - dst.getY()) <= 1;
	}

	public String toString() {
		return (isWhite) ? "WK" : "BK";
	}
}
