package com.javalessons.Chess.Core;

import com.javalessons.Chess.Core.Utils.Vector;

public class Move {
    private Vector source;
    private Vector destination;

    public Move(Vector source, Vector destination) {
        this.source = source;
        this.destination = destination;
    }
}
