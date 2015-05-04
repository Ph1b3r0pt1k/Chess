package pieces;
import point.Point;
import board.Board;

public class Queen extends Piece {
	public Queen (Point location, boolean isWhite) {
		this.location = location;
		this.isWhite = isWhite;
	} // end constructor
	public boolean canMove(Point location) {
		return true;
	} // End move
	
	public String toString() {
		if (isWhite == true) {
			return "WQ";
		}
		else {
			return "BQ";
		}
	} // End toString
} // end class
