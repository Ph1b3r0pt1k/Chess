package pieces;
import board.Board;
import point.Point;
import exceptions.InvalidPointException;
import exceptions.NoPieceAtPointException;

public class Pawn extends Piece {
	private boolean hasMoved;

	public Pawn (Point location, boolean isWhite) {
		this.location = location;
		this.isWhite = isWhite;
		hasMoved = false;
	}

	public boolean canMove(Point dst) {
		try {
			
			int moveDist =  dst.getY() - location.getY();
			if (moveIsStraight(dst)) {
				
				if (!moveIsForward(dst)) return false;
				
				if (!moveIsOneOrTwoSquaresForward(moveDist)) return false;
				
				if (moveIsTwoSquaresForward(moveDist)) {
					if (hasMoved) return false;
					else if (thereIsPieceOnMiddleSquare(moveDist)) return false;
				}
				
				if (thereIsPieceAtDestination(dst)) return false;
				else {
					hasMoved = true;
					return true;
				}
			}
			
			if (!isCapture(dst)) return false;
			
			if (!moveIsForward(dst)) return false;
			
			if (!isFriendly(dst)) {
				hasMoved = true;
				return true;
			}
			
			return false;
		} catch (InvalidPointException e) {
			return false;
		} catch (NoPieceAtPointException e) {
			return false;
		}
	}
	
	private boolean isCapture(Point dst) {
		return Math.abs(location.getX() - dst.getX()) == 1 && Math.abs(location.getY() - dst.getY()) == 1;
	}

	private boolean moveIsStraight(Point dst) {
		return dst.getX() == location.getX();
	}
	
	private boolean moveIsForward(Point dst) {
		if (this.isWhite()) {
			return !whitePawnMovingBackwards(dst);
		} 
		else {
			return !blackPawnMovingBackwards(dst);
		}
	}
	
	private boolean moveIsOneOrTwoSquaresForward(int moveDist) {
		return Math.abs(moveDist) == 1 || Math.abs(moveDist) == 2;
	}
	
	private boolean moveIsTwoSquaresForward(int moveDist) {
		return Math.abs(moveDist) == 2;
	}
	
	private boolean thereIsPieceOnMiddleSquare(int moveDist) throws InvalidPointException {
		if (moveDist < 0) {
			if (Board.getInstance().thereIsPiece(new Point(location.getX(), location.getY() - 1))) return true;
		}
		else {
			if (Board.getInstance().thereIsPiece(new Point(location.getX(), location.getY() + 1))) return true;
		}
		
		return false;
	}
	
	private boolean thereIsPieceAtDestination(Point dst) throws InvalidPointException {
		return Board.getInstance().thereIsPiece(dst);
	}
	
	private boolean whitePawnMovingBackwards(Point dst) {
		return dst.getY() <= location.getY();
	}
	
	private boolean blackPawnMovingBackwards(Point dst) {
		return dst.getY() >= location.getY();
	}

	public String toString() {
		return (isWhite) ? "WP" : "BP";
	}
}
