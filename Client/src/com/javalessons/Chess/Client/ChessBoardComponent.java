package com.javalessons.Chess.Client;

import com.javalessons.Chess.Core.ChessBoard;
import com.javalessons.Chess.Core.Piece.AbstractPiece;
import com.javalessons.Chess.Core.Piece.Visitor.Impl.GetImageFileNameVisitor;
import com.javalessons.Chess.Core.Utils.Vector;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ChessBoardComponent extends JComponent {
    private ChessBoard board;

    public ChessBoardComponent(ChessBoard board) {
        super();
        this.board = board;
    }

    private Image loadImage(AbstractPiece piece) {
        GetImageFileNameVisitor visitor = new GetImageFileNameVisitor();
        String fileName = (String) piece.accept(visitor);
        try {
            return ImageIO.read(getClass().getResourceAsStream("/pieces/" + fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        int minDimension = Math.min(this.getWidth(), this.getHeight());

        int cellSize = minDimension / ChessBoard.SIZE;
        int marginWidth = (this.getWidth() - minDimension) / 2;
        int marginHeight = (this.getHeight() - minDimension) / 2;

        for (int y = 0; y < ChessBoard.SIZE; y++) {
            for (int x = 0; x < ChessBoard.SIZE; x++) {
                boolean isWhite = ((x + y) % 2 == 0);
                graphics.setColor(isWhite ? Color.WHITE : Color.BLACK);
                graphics.fillRect(Math.min(getWidth(), marginWidth + x * cellSize), Math.min(getHeight(), marginHeight + y * cellSize), Math.min(getWidth(), marginWidth + (x + 1) * cellSize), Math.min(getHeight(), marginHeight + (y + 1) * cellSize));

                if (board.hasPiece(new Vector(x, y))) {
                    graphics.drawImage(loadImage(board.getPiece(x, y)), marginWidth + x * cellSize, marginHeight + y * cellSize, cellSize, cellSize, null);
                }
            }
        }
    }
}
