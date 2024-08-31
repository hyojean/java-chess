package model;

import java.util.Map;

public class Bishop extends Piece {

    public Bishop(char symbol, String color) {
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

        // 비숍은 대각선으로만 이동 가능
        if (colDiff == rowDiff) {
            return isPathClear(source, target, board);
        }
        return false;
    }

    private boolean isPathClear(String source, String target, ChessBoard board) {
        // 대각선 경로에 장애물이 있는지 확인하는 로직 추가
        char sourceCol = source.charAt(0);
        char targetCol = target.charAt(0);
        int sourceRow = source.charAt(1) - '0';
        int targetRow = target.charAt(1) - '0';

        int colStep = sourceCol < targetCol ? 1 : -1;
        int rowStep = sourceRow < targetRow ? 1 : -1;

        int col = sourceCol + colStep;
        int row = sourceRow + rowStep;

        while (col != targetCol && row != targetRow) {
            if (board.getPieceAt((char) col + String.valueOf(row)) != null) {
                return false;
            }
            col += colStep;
            row += rowStep;
        }

        return true;
    }

    @Override
    public double getScore(Map<String, Piece> board) {
        return 3.0;
    }
}
