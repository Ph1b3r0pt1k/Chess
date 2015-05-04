package pieces;
import exceptions.*;
import board.*;
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
	
	public abstract boolean canMove(Point location);
	
	public abstract String toString();
	
	public boolean isEnemy(Point loc) throws InvalidPointException, NoPieceAtPointException {
		if (this.isWhite) {
			return !Board.getInstance().isWhite(loc);
		} else {
			return Board.getInstance().isWhite(loc);
		}
	}
	
	public boolean isFriendly(Point loc) throws InvalidPointException, NoPieceAtPointException {
		if (this.isWhite) {
			return Board.getInstance().isWhite(loc);
		} else {
			return !Board.getInstance().isWhite(loc);
		}
	}

} // end class
