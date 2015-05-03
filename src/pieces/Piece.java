package pieces;
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
	
	public abstract boolean move(Piece [][] board, Point location);
	
	public abstract String toString();

} // end class
