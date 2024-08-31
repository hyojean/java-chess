package model;

import java.util.Map;

public class Queen extends Piece {

    public Queen(char symbol, String color) {
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

        // 퀸은 직선 또는 대각선 이동 가능
        if (sourceCol == targetCol || sourceRow == targetRow || colDiff == rowDiff) {
            return new Rook('R', getColor()).isValidMove(source, target, board)
                    || new Bishop('B', getColor()).isValidMove(source, target, board);
        }
        return false;
    }

    @Override
    public double getScore(Map<String, Piece> board) {
        return 9.0;
    }
}
