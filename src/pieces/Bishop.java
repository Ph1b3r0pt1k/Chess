package pieces;
import board.Board;
import point.*;

public class Bishop extends Piece {
	public Bishop (Point location, boolean isWhite) {
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
			return "WB";
		}
		else {
			return "BB";
		}
	} // End toString
} // End class
