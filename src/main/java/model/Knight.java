package model;

public class Knight extends Piece {

    public Knight(char symbol, String color) {
        super(symbol, color);
    }

    @Override
    public boolean isValidMove(String source, String target, ChessBoard board) {
        char sourceCol = source.charAt(0);
        char targetCol = target.charAt(0);
        int sourceRow = source.charAt(1) - '0';
        int targetRow = target.charAt(1) - '0';

        int colDiff = Math.abs(sourceCol - targetCol);
        int rowDiff = Math.abs(sourceRow - targetRow);

        // 나이트는 L자 모양으로 이동
        return (colDiff == 2 && rowDiff == 1) || (colDiff == 1 && rowDiff == 2);
    }
}
