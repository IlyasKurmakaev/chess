package com.javalessons.Chess.Core.Piece.Impl;

import com.javalessons.Chess.Core.Piece.AbstractPiece;
import com.javalessons.Chess.Core.Piece.Visitor.IAbstractPieceVisitor;
import com.javalessons.Chess.Core.PlayerSide;

public class Knight extends AbstractPiece {
    public Knight(PlayerSide side) {
        super(side);
    }

    @Override
    public Object accept(IAbstractPieceVisitor visitor) {
        return visitor.visit(this);
    }
}
