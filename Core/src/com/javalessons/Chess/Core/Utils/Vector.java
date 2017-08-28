package com.javalessons.Chess.Core.Utils;

public class Vector {
    public static Vector IDENTITY = new Vector(1, 1);

    private int x;
    private int y;

    private enum Axis { X, Y }
    private enum Direction { CW, CCW };

    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector() {
        this(0, 0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Vector copy() {
        return new Vector(this.x, this.y);
    }

    public Vector plus(Vector vector)
    {
        Vector temp = copy();
        temp.x += vector.x;
        temp.y += vector.y;

        return temp;
    }

    public Vector minus(Vector vector) {
        return plus(vector.negate());
    }

    public Vector multiply(int k) {
        Vector temp = copy();
        temp.x *= k;
        temp.y *= k;

        return temp;
    }

    public Vector negate() {
        return multiply(-1);
    }

    public Vector mirror(Axis axis)
    {
        if (axis == Axis.X) {
            return new Vector(-x, y);
        } else {
            return new Vector(x, -y);
        }
    }

    public Vector rotate(Direction direction)
    {
        if (direction == Direction.CW){
            return new Vector(y, -x);
        } else {
            return new Vector(-y, x);
        }
    }
}
