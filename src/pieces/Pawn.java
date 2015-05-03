package pieces;
import point.*;

public class Pawn extends Piece {
	private boolean hasMoved = false;
	
	public Pawn (Point location, boolean isWhite) {
		this.location = location;
		this.isWhite = isWhite;
	} // End constructor
	
	public boolean move(Piece [][] board, Point location) {
		if (hasMoved == false) {
			return true;
		}
		else {
			hasMoved = true;
			return false;
		}
	} // End move
	public void capture(Piece [][] board, Point location) {
		
	} // End capture
	
	public String toString() {
		if (isWhite == true) {
			return "WP";
		}
		else {
			return "BP";
		}
	} // End toString
} // End class
