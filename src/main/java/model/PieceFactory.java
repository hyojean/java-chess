package model;

public class PieceFactory {
    public static Piece createPiece(char symbol, String color) {
        switch (Character.toLowerCase(symbol)) {
            case 'p':
                return new Pawn(symbol, color);
            case 'r':
                return new Rook(symbol, color);
            case 'n':
                return new Knight(symbol, color);
            case 'b':
                return new Bishop(symbol, color);
            case 'q':
                return new Queen(symbol, color);
            case 'k':
                return new King(symbol, color);
            default:
                throw new IllegalArgumentException("Invalid piece symbol: " + symbol);
        }
    }
}
