package pieces;
import exceptions.InvalidPointException;
import exceptions.NoPieceAtPointException;
import board.Board;
import point.*;

public abstract class Piece {
	protected Point location;
	protected boolean isWhite;
	
	public Point getLocation() {
		return location;
	}
	public void setLocation(Point location) {
		this.location = location;
	}
	public boolean isWhite() {
		return isWhite;
	}
	public void setWhite(boolean isWhite) {
		this.isWhite = isWhite;
	}
	
	public abstract boolean canMove(Board board, Point location);
	
	public abstract String toString();
	
	public boolean isEnemy(Board board, Point loc) throws InvalidPointException, NoPieceAtPointException {
		if (this.isWhite) {
			return !board.isWhite(loc);
		} else {
			return board.isWhite(loc);
		}
	}
	
	public boolean isFriendly(Board board, Point loc) throws InvalidPointException, NoPieceAtPointException {
		System.out.printf("isvalidpoint: %d, %d\n", loc.getX(), loc.getY());
		if (this.isWhite) {
			return board.isWhite(loc);
		} else {
			return !board.isWhite(loc);
		}
	}

} // end class
