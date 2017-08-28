package com.javalessons.Chess.Core.Piece.Visitor;

import com.javalessons.Chess.Core.Piece.Impl.*;

public interface IAbstractPieceVisitor {
    public Object visit(Bishop piece);
    public Object visit(King piece);
    public Object visit(Knight piece);
    public Object visit(Pawn piece);
    public Object visit(Queen piece);
    public Object visit(Rook piece);
}
