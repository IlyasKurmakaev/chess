package com.javalessons.Chess.Core.Piece.Visitor.Impl;

import com.javalessons.Chess.Core.Piece.AbstractPiece;
import com.javalessons.Chess.Core.Piece.Impl.*;
import com.javalessons.Chess.Core.Piece.Visitor.IAbstractPieceVisitor;

public class GetImageFileNameVisitor implements IAbstractPieceVisitor {
    private GetPieceTypeVisitor pieceTypeVisitor = new GetPieceTypeVisitor();

    private String getFileName(AbstractPiece piece) {
        String sideString = String.valueOf(piece.getSide().name().charAt(0)).toLowerCase();
        String pieceName = ((AbstractPiece.PieceType) piece.accept(pieceTypeVisitor)).name().toLowerCase();

        return sideString + "_" + pieceName + "_png_noShadow.png";
    }

    @Override
    public Object visit(Bishop piece) {
        return getFileName(piece);
    }

    @Override
    public Object visit(King piece) {
        return getFileName(piece);
    }

    @Override
    public Object visit(Knight piece) {
        return getFileName(piece);
    }

    @Override
    public Object visit(Pawn piece) {
        return getFileName(piece);
    }

    @Override
    public Object visit(Queen piece) {
        return getFileName(piece);
    }

    @Override
    public Object visit(Rook piece) {
        return getFileName(piece);
    }
}
