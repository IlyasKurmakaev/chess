package com.javalessons.Chess.Core.Piece;

import com.javalessons.Chess.Core.Piece.Visitor.IAbstractPieceVisitor;
import com.javalessons.Chess.Core.PlayerSide;

public abstract class AbstractPiece {
    public enum PieceType {
        PAWN,
        KNIGHT,
        BISHOP,
        ROOK,
        QUEEN,
        KING
    }

    private PlayerSide side;

    public AbstractPiece(PlayerSide side) {
        this.side = side;
    }

    public PlayerSide getSide() {
        return side;
    }

    public abstract Object accept(IAbstractPieceVisitor visitor);
}
