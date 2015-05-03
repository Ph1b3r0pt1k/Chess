package pieces;
import point.*;

public class Queen extends Piece {
	public Queen (Point location, boolean isWhite) {
		this.location = location;
		this.isWhite = isWhite;
	} // end constructor
	public boolean move(Piece [][] board, Point location) {
		return true;
	} // end move
	
	public String toString() {
		if (isWhite == true) {
			return "WQ";
		}
		else {
			return "BQ";
		}
	} // End toString
} // end class
