package com.javalessons.Chess.Core;

import com.javalessons.Chess.Core.Piece.AbstractPiece;
import com.javalessons.Chess.Core.Piece.Impl.King;
import com.javalessons.Chess.Core.Piece.Impl.Rook;
import com.javalessons.Chess.Core.Utils.Vector;

public class ChessBoard {
    public static final int SIZE = 8;
    public PlayerSide progressOfSide;
    public boolean castlingKingWhite;
    public boolean castlingQueanWhite;
    public boolean castlingKingBlack;
    public boolean castlingQueanBlack;
    public String passAttack = "";
    public String nullStrocke = "";
    public String numStrocke = "";

    public AbstractPiece content[][] = new AbstractPiece[SIZE][SIZE];


    public boolean hasPiece(Vector position) {
         return getPiece(position) != null;
    }

    public AbstractPiece getPiece(Vector position) {
        return content[position.getX()][position.getY()];
    }

    public AbstractPiece getPiece(int x, int y) {
        return getPiece(new Vector(x, y));
    }

    public void makeMove(Move move) {

    }


    public ChessBoard initial() {
        ChessBoard board = new ChessBoard();
        NotationParser notationParser = new NotationParser("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1", board);
        notationParser.arrangeFigures();
        System.out.println(board.progressOfSide + "." +  board.castlingKingBlack + "." + board.castlingKingWhite + "." + board.castlingQueanWhite + "." + board.castlingQueanBlack  + "." + board.passAttack + "."  + board.nullStrocke + "." + board.numStrocke);

        return board;
    }
}
