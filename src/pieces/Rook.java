package pieces;
import point.*;
import board.*;
import exceptions.*;

public class Rook extends Piece {
	public Rook(Point location, boolean isWhite) {
		this.location = location;
		this.isWhite = isWhite;
	}
	public boolean canMove(Point dst) {
		try {
			if (moveIsStraightLine(dst)) {
				if (moveIsHorizontal(dst)) {
					return moveHorizontal(dst);
				}
				else if (moveIsVertical(dst)) {
					return moveVertical(dst);
				}
				else return false;
			}
			else return false;

		} catch (InvalidPointException e) {
			return false;
		} catch (NoPieceAtPointException e) {
			return true;
		}
	}
	
	private boolean moveHorizontal(Point dst) throws InvalidPointException, NoPieceAtPointException {
		int j = (location.getX() - dst.getX() > 0) ? -1: 1;
		
		for (int i = location.getX() + j; i != dst.getX(); i += j) {
			if (Board.getInstance().thereIsPiece(new Point(i, location.getY()))) {
				System.out.println("Invalid move.");
				return false;
			}
		}
		return !isFriendly(dst);
	}
	
	private boolean moveVertical(Point dst) throws InvalidPointException, NoPieceAtPointException {
		int j = (location.getY() - dst.getY() > 0) ? -1: 1;
		
		for (int i = location.getY() + j; i != dst.getY(); i += j) {
			if (Board.getInstance().thereIsPiece(new Point(location.getX(), i))) {
				System.out.println("Invalid move.");
				return false;
			}
		}

		return !isFriendly(dst);
	}
	
	private boolean moveIsHorizontal(Point dst) {
		return location.getY() == dst.getY();
	}
	
	private boolean moveIsVertical(Point dst) {
		return location.getX() == dst.getX();
	}
	
	private boolean moveIsStraightLine(Point dst) {
		return (moveIsHorizontal(dst) || moveIsVertical(dst));
	}
	
	public String toString() {
		return (isWhite) ? "WR" : "BR";
	}
}
