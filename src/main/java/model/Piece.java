package model;

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

    public boolean isWhite() {
        return "white".equals(this.color);
    }

    public abstract boolean isValidMove(String source, String target, ChessBoard board);
}
