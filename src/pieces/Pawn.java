package pieces;
import point.Point;
import board.Board;

public class Pawn extends Piece {
	private boolean hasMoved = false;
	
	public Pawn (Point location, boolean isWhite) {
		this.location = location;
		this.isWhite = isWhite;
	} // End constructor
	
	public boolean canMove(Board board, Point location) {
		return true;
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
