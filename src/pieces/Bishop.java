package pieces;
import point.*;
import board.*;
import exceptions.*;

public class Bishop extends Piece {
	public Bishop (Point location, boolean isWhite) {
		this.location = location;
		this.isWhite = isWhite;
	} // End constructor
	public boolean canMove(Point dst) {
		if (Math.abs(dst.getX() - location.getX()) == Math.abs(dst.getY() - location.getY())) { // Move is diagonal
			try {
				
				
				if (dst.getX() > location.getX() && dst.getY() < location.getY()) { // Right, down
					int i = location.getX();
					int j = location.getY();
					while (i < dst.getX() - 1) {
						if (!Board.getInstance().thereIsPiece(new Point(i + 1, j - 1))) {
							// keep going
						} else {
							System.out.println("Invalid move 1.");
							return false;
						}
						i++;
						j--;
					} // end while
				} // end right, down
				
				else if (dst.getX() > location.getX() && dst.getY() > location.getY()) { // Right, up
					int i = location.getX();
					int j = location.getY();
					while (i < dst.getX() - 1) {
						if (!Board.getInstance().thereIsPiece(new Point(i + 1, j + 1))) {
							// keep going
						} else {
							System.out.println("Invalid move 2.");
							return false;
						}
						i++;
						j++;
					} // end while
				} // end right, up
				
				else if (dst.getX() < location.getX() && dst.getY() < location.getY()) { // Left, down
					int i = location.getX();
					int j = location.getY();
					while (i > dst.getX() + 1) {
						if (!Board.getInstance().thereIsPiece(new Point(i - 1, j - 1))) {
							// keep going
						} else {
							System.out.println("Invalid move 3.");
							return false;
						}
						i--;
						j--;
					} // end while
				} // end left, down
				
				else if (dst.getX() < location.getX() && dst.getY() > location.getY()) { // Left, up
					int i = location.getX();
					int j = location.getY();
					while (i > dst.getX() + 1) {
						if (!Board.getInstance().thereIsPiece(new Point(i - 1, j + 1))) {
							// keep going
						} else {
							System.out.println("Invalid move 4.");
							return false;
						}
						i--;
						j++;
					} // end while
				} // end left, up
				
				else {
					System.out.println("Invalid (and strange) move.");
					return false;
				}
				return !isFriendly(dst);
				
			} catch (InvalidPointException e) {
				System.out.println("Invalid point exception.");
				return false;
			} catch (NoPieceAtPointException e) {
				return true;
			}
		} // end move is diagonal
		
		
		else {
			System.out.println("Move is not diagonal.");
			return false;
		}
	} // end canMove

	public String toString() {
		if (isWhite == true) {
			return "WB";
		}
		else {
			return "BB";
		}
	} // End toString
} // End class
