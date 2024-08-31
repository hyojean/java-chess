package model;

public class King extends Piece {

    public King(char symbol, String color) {
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

        // 킹은 한 칸씩만 이동 가능
        return colDiff <= 1 && rowDiff <= 1;
    }
}
