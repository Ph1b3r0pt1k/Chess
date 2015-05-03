package pieces;
import point.*;

public class King extends Piece {
	private boolean inCheck = false;
	
	public King(Point location, boolean isWhite) {
		this.location = location;
		this.isWhite = isWhite;
	}
	public boolean move(Piece [][] board, Point location) {
		if (inCheck == true) {
			return true;
		}
		else {
			return false;
		}
	} // End move
	public void capture(Piece [][] board, Point location) {
		
	} // End capture
	
	public String toString() {
		if (isWhite == true) {
			return "WK";
		}
		else {
			return "BK";
		}
	} // End toString
} // End class
