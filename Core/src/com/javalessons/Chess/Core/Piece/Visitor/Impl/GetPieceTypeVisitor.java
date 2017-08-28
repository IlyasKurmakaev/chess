package com.javalessons.Chess.Core.Piece.Visitor.Impl;

import com.javalessons.Chess.Core.Piece.AbstractPiece;
import com.javalessons.Chess.Core.Piece.Impl.*;
import com.javalessons.Chess.Core.Piece.Visitor.IAbstractPieceVisitor;

public class GetPieceTypeVisitor implements IAbstractPieceVisitor {
    @Override
    public Object visit(Bishop piece) {
        return AbstractPiece.PieceType.BISHOP;
    }

    @Override
    public Object visit(King piece) {
        return AbstractPiece.PieceType.KING;
    }

    @Override
    public Object visit(Knight piece) {
        return AbstractPiece.PieceType.KNIGHT;
    }

    @Override
    public Object visit(Pawn piece) {
        return AbstractPiece.PieceType.PAWN;
    }

    @Override
    public Object visit(Queen piece) {
        return AbstractPiece.PieceType.QUEEN;
    }

    @Override
    public Object visit(Rook piece) {
        return AbstractPiece.PieceType.ROOK;
    }
}
