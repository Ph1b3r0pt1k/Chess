package pieces;
import point.Point;
import board.Board;
import exceptions.InvalidPointException;
import exceptions.NoPieceAtPointException;

public class Knight extends Piece {
	public Knight(Point location, boolean isWhite) {
		this.location = location;
		this.isWhite = isWhite;
	} // End constructor
	public boolean isEnemy(Board board, Point loc) throws InvalidPointException, NoPieceAtPointException {
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
	@Override
	public boolean canMove(Board board, Point location) {
		// TODO Auto-generated method stub
		return false;
	}
} // End class
