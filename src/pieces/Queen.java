package pieces;
import exceptions.InvalidPointException;
import exceptions.NoPieceAtPointException;
import point.Point;
import board.Board;

public class Queen extends Piece {
	public Queen (Point location, boolean isWhite) {
		this.location = location;
		this.isWhite = isWhite;
	}
	
	public boolean canMove(Point dst) {
		try {
			if (moveIsDiagonal(dst)) {
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
			}

			else if (moveIsStraightLine(dst)) {
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
		return (isWhite) ? "WQ" : "BQ"; 
	}
}
