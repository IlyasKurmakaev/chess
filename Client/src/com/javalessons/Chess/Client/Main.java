package com.javalessons.Chess.Client;

import com.javalessons.Chess.Core.ChessBoard;

import javax.swing.*;

public class Main {

    public static void main(String args[]) {
        ChessBoardComponent component = new ChessBoardComponent(new ChessBoard().initial());

        component.setSize(500, 300);
        JFrame frame = new JFrame();
        frame.setSize(470, 500);
        frame.add(component);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
