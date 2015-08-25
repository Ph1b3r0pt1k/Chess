package pieces;
import board.Board;
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
			int moveDist = -1;
			// Forward move, no capture
			if (dst.getX() == location.getX()) {
				
				// Forward movement only
				if (this.isWhite()) { // White pawn
					if (dst.getY() <= location.getY()) {
						System.out.println("Pawns must move forward.");
						return false;
					}
				} // end if
				else { // Black pawn
					if (dst.getY() >= location.getY()) {
						System.out.println("Pawns must move forward.");
						return false;
					}
				} // end else
				
				moveDist =  dst.getY() - location.getY();
				
				if (Math.abs(moveDist) != 1 && Math.abs(moveDist) != 2) {
					return false;
				}
				
				if (Math.abs(moveDist) == 2) {
					if (hasMoved) {
						System.out.println("That piece has already moved.");
						return false;
					} else {
						// check square in middle
						if (moveDist < 0) {
							if (Board.getInstance().thereIsPiece(new Point(location.getX(), location.getY() - 1))) {
								return false;
							}
						} else {
							if (Board.getInstance().thereIsPiece(new Point(location.getX(), location.getY() + 1))) {
								return false;
							}
						}
					}
				}
				
				// check destination square
				if (Board.getInstance().thereIsPiece(dst)) {
					return false;
				}
				
				hasMoved = true;
				return true;
				
			} // end if - forward move, no capture
			
			if (!(Math.abs(location.getX() - dst.getX()) == 1 && Math.abs(location.getY() - dst.getY()) == 1)) {
				return false;
			}
			
			if (this.isWhite()) { // White pawn
				if (dst.getY() <= location.getY()) {
					System.out.println("Pawns must move forward.");
					return false;
				}
			} // end if
			else { // Black pawn
				if (dst.getY() >= location.getY()) {
					System.out.println("Pawns must move forward.");
					return false;
				}
			} // end else
			
			if (!isFriendly(dst)) {
				hasMoved = true;
				return true;
			}
			
			return false;
		} catch (InvalidPointException e) {
			return false;
		} catch (NoPieceAtPointException e) {
			return false;
		}
	} // End canMove

	public String toString() {
		if (isWhite == true) {
			return "WP";
		}
		else {
			return "BP";
		}
	} // End toString
} // End class
