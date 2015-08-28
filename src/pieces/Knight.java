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
	}
	
	public boolean canMove(Point dst) {
		try {
			if (Board.getInstance().isInvalidPoint(dst)) return false;
			
			for (Point p : this.possibleKnightMoves()) {
				if (pointIsKnightMove(p, dst)) {
					return !isFriendly(dst);
				}
			}
			return false;
			
		} catch (InvalidPointException e) {
			return false;
		} catch (NoPieceAtPointException e) {
			return true;
		}
	}
	private boolean pointIsKnightMove(Point p, Point dst) {
		return p.getX() == dst.getX() && p.getY() == dst.getY();
	}

	private ArrayList<Point> possibleKnightMoves() {
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
	
	public String toString() {
		return (isWhite) ? "WN" : "BN";
	}
}
