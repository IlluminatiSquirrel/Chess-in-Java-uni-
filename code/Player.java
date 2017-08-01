package uk.ac.sheffield.aca14gk;

/*
 * Player.java  	1.1 26/01/2015
 *
 * Copyright (c) University of Sheffield 2015
 */
 

/**
* Player.java 
*
* Abstract class to represent a chess player
*
* @version 1.1 26 January 2015
*
* @author Richard Clayton  (r.h.clayton@sheffield.ac.uk), Steve Maddock (s.c.maddock@sheffield.ac.uk)
*/

public abstract class Player {

	public static final int BLACK = 0;
	public static final int WHITE = 1;

	private String name;
	private Pieces pieces;
	private Board board;
	private Player opponent;
	

	public Player (String n, Pieces p, Board b, Player o) {
		name = n;
		pieces = p;
		board = b;
		opponent = o;
	}

	public Board getBoard() {
		return board;
	}

	public Player getOpponent() {
		return opponent;
	}

	public void setOpponent(Player p) {
		opponent = p;
	}

	public Pieces getPieces() {
		return pieces;
	}

	public abstract boolean makeMove();
 
	public void deletePiece(Piece p) {
		pieces.delete(p);
	}

	public String toString() {
		return name;
	}
  
	//returns true if white king is still in game
	public boolean whiteKingCheck(){
		String s = getPieces().toString();
		if (getPieces().getPiece(1).getColour() == 1)
			if (s.contains("k"))
				return true;
		return false;
	}
	
	// returns true if black king is still in game
	public boolean blackKingCheck(){
		String s = getPieces().toString();
		if (getPieces().getPiece(1).getColour() == 0)
			if (s.contains("K"))
				return true;
		return false;
	}
}
