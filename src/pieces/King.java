package pieces;
import board.*;
import point.*;

public class King extends Piece {
	private boolean inCheck = false;
	
	public King(Point location, boolean isWhite) {
		this.location = location;
		this.isWhite = isWhite;
	}
	public boolean canMove(Point location) {
		return true;
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
