package pieces;
import board.*;
import point.*;

public class Bishop extends Piece {
	public Bishop (Point location, boolean isWhite) {
		this.location = location;
		this.isWhite = isWhite;
	} // End constructor
	public boolean canMove(Point location) {
		return true;
	}
	
	public String toString() {
		if (isWhite == true) {
			return "WB";
		}
		else {
			return "BB";
		}
	} // End toString
} // End class
