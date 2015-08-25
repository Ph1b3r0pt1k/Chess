package pieces;
import exceptions.InvalidPointException;
import exceptions.NoPieceAtPointException;
import point.Point;
import board.Board;

public class Queen extends Piece {
	public Queen (Point location, boolean isWhite) {
		this.location = location;
		this.isWhite = isWhite;
	} // end constructor
	public boolean canMove(Point dst) {

		// Move is diagonal
		try {
			if (Math.abs(dst.getX() - location.getX()) == Math.abs(dst.getY() - location.getY())) {
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

			} // end move is diagonal

			// move is horizontal
			else if (location.getY() == dst.getY()) {
				int j = (location.getX() - dst.getX() > 0) ? -1: 1;
				for (int i = location.getX() + j; i != dst.getX(); i += j) {
					if (!Board.getInstance().thereIsPiece(new Point(i, location.getY()))) {
						// keep going
					} else {
						System.out.println("Invalid move.");
						return false;
					}
				} // end for

				return !isFriendly(dst);
			}

			// move is vertical
			else if (location.getX() == dst.getX()) {
				int j = (location.getY() - dst.getY() > 0) ? -1: 1;
				for (int i = location.getY() + j; i != dst.getY(); i += j) {
					if (!Board.getInstance().thereIsPiece(new Point(location.getX(), i))) {
						// keep going
					}
					else {
						System.out.println("Invalid move.");
						return false;
					}
				}
				return !isFriendly(dst);
			} // end vertical move


			else { // move is neither diagonal nor horizontal
				System.out.println("Move is not diagonal.");
				return false;
			}
		} catch (InvalidPointException e) {
			System.out.println("Invalid point exception.");
			return false;
		} catch (NoPieceAtPointException e) {
			return true;
		}
	} // End canMove

	public String toString() {
		if (isWhite == true) {
			return "WQ";
		}
		else {
			return "BQ";
		}
	} // End toString
} // end class
