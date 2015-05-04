package pieces;
import java.util.*;

import board.Board;
import point.Point;
import exceptions.InvalidPointException;
import exceptions.NoPieceAtPointException;

public class Knight extends Piece {
	public Knight(Point location, boolean isWhite) {
		this.location = location;
		this.isWhite = isWhite;
	} // End constructor

	public String toString() {
		if (isWhite == true) {
			return "WN";
		}
		else {
			return "BN";
		}
	} // End toString
	@Override
	public boolean canMove(Point dst) {
		try {
			if (Board.getInstance().isInvalidPoint(dst)) {
				return false;
			}
			for (Point p : this.generateMoves()) {
				if (p.getX() == dst.getX() && p.getY() == dst.getY()) {
					if (isFriendly(dst)) {
						return false;
					} else {
						return true;
					}
				}
			} // end for
			return false;
		} catch (InvalidPointException e) {
			System.out.println("Can't move. Invalid point exception.");
			return false;
		} catch (NoPieceAtPointException e) {
			return true;
		}
	} // end canMove
	private ArrayList<Point> generateMoves() {
		ArrayList<Point> moves = new ArrayList<Point>();
		moves.add(new Point(location.getX() + 2, location.getY() + 1));
		moves.add(new Point(location.getX() + 2, location.getY() - 1));
		moves.add(new Point(location.getX() + 1, location.getY() + 2));
		moves.add(new Point(location.getX() + 1, location.getY() - 2));
		moves.add(new Point(location.getX() - 2, location.getY() + 1));
		moves.add(new Point(location.getX() - 2, location.getY() - 1));
		moves.add(new Point(location.getX() - 1, location.getY() + 2));
		moves.add(new Point(location.getX() - 1, location.getY() - 2));
		return moves;
	}
} // End class
