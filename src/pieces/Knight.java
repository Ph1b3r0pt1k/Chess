package pieces;
import point.*;

public class Knight extends Piece {
	public Knight(Point location, boolean isWhite) {
		this.location = location;
		this.isWhite = isWhite;
	} // End constructor
	public boolean move(Piece [][] board, Point location) {
		return true;
	} // End move
	
	public String toString() {
		if (isWhite == true) {
			return "WN";
		}
		else {
			return "BN";
		}
	} // End toString
} // End class
