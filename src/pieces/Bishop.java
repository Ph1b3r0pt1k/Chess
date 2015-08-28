package pieces;
import point.*;
import board.*;
import exceptions.*;

public class Bishop extends Piece {
	public Bishop (Point location, boolean isWhite) {
		this.location = location;
		this.isWhite = isWhite;
	}
	
	public boolean canMove(Point dst) {
		if (moveIsDiagonal(dst)) {
			try {			
				if (rightAndDown(dst)) {
					return moveRightAndDown(dst);
				}
				
				else if (rightAndUp(dst)) {
					return moveRightAndUp(dst);
				}
				
				else if (leftAndDown(dst)) {
					return moveLeftAndDown(dst);
				}
				
				else if (leftAndUp(dst)) {
					return moveLeftAndUp(dst);
				}
				
				else {
					return false;
				}
				
			} catch (InvalidPointException e) {
				return false;
			} catch (NoPieceAtPointException e) {
				return true;
			}
		}
		
		else {
			return false;
		}
	}
	
	private boolean moveIsDiagonal(Point dst) {
		return Math.abs(dst.getX() - location.getX()) == Math.abs(dst.getY() - location.getY());
	}

	private boolean rightAndDown(Point dst) {
		return dst.getX() > location.getX() && dst.getY() < location.getY();
	}
	
	private boolean rightAndUp(Point dst) {
		return dst.getX() > location.getX() && dst.getY() < location.getY();
	}
	
	private boolean leftAndDown(Point dst) {
		return dst.getX() < location.getX() && dst.getY() < location.getY();
	}
	
	private boolean leftAndUp(Point dst) {
		return dst.getX() < location.getX() && dst.getY() > location.getY();
	}

	private boolean moveLeftAndUp(Point dst) throws InvalidPointException, NoPieceAtPointException {
		int i = location.getX();
		int j = location.getY();
		while (i > dst.getX() + 1) {
			if (Board.getInstance().thereIsPiece(new Point(i - 1, j + 1))) return false;
			else {
				i--;
				j++;
			}
		}

		return !isFriendly(dst);
	}

	private boolean moveLeftAndDown(Point dst) throws InvalidPointException, NoPieceAtPointException {
		int i = location.getX();
		int j = location.getY();
		while (i > dst.getX() + 1) {
			if (Board.getInstance().thereIsPiece(new Point(i - 1, j - 1))) return false;	
			else {
				i--;
				j--;
			}
		}
		
		return !isFriendly(dst);
	}

	private boolean moveRightAndUp(Point dst) throws InvalidPointException, NoPieceAtPointException {
		int i = location.getX();
		int j = location.getY();
		while (i < dst.getX() - 1) {
			if (Board.getInstance().thereIsPiece(new Point(i + 1, j + 1))) return false;
			else {
				i++;
				j++;
			}
		}
		
		return !isFriendly(dst);
	}

	private boolean moveRightAndDown(Point dst) throws InvalidPointException, NoPieceAtPointException {
		int i = location.getX();
		int j = location.getY();
		while (i < dst.getX() - 1) {
			if (Board.getInstance().thereIsPiece(new Point(i + 1, j - 1))) return false;
			else {
				i++;
				j--;
			}
		}
		
		return !isFriendly(dst);
	}

	public String toString() {
		return (isWhite) ? "WB" : "BB";
	}
}
