package pieces;
import point.Point;
import exceptions.InvalidPointException;
import exceptions.NoPieceAtPointException;

public class Pawn extends Piece {
	private boolean hasMoved;

	public Pawn (Point location, boolean isWhite) {
		this.location = location;
		this.isWhite = isWhite;
		hasMoved = false;
	} // End constructor

	public boolean canMove(Point dst) {
		try {
			if (dst.getX() == location.getX()) {
				if (this.isWhite()) {
					if (dst.getY() <= location.getY()) {
						System.out.println("Pawns must move forward.");
						return false;
					}
				} // end if
				else {
					if (dst.getY() >= location.getY()) {
						System.out.println("Pawns must move forward.");
						return false;
					}
				} // end else1
				if (Math.abs(dst.getY() - location.getY()) == 1) {
					return !isFriendly(dst);
				}
				else {

				}
			}
			else {
				return false;
			}

			return true;
		} catch (NoPieceAtPointException e) {
			return true;
		} catch (InvalidPointException e) {
			return false;
		}
	} // End move

	public String toString() {
		if (isWhite == true) {
			return "WP";
		}
		else {
			return "BP";
		}
	} // End toString
} // End class
