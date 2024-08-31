package model;

import java.util.Map;

public abstract class Piece {
    private final char symbol;
    private final String color;

    protected Piece(char symbol, String color) {
        this.symbol = symbol;
        this.color = color;
    }

    public char getSymbol() {
        return symbol;
    }

    public String getColor() {
        return color;
    }

    public boolean isKing() {
        return this instanceof King;
    }

    public abstract boolean isValidMove(String source, String target, ChessBoard board);

    public abstract double getScore(Map<String, Piece> board);
}
