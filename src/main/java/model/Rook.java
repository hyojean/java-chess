package model;

import java.util.Map;

public class Rook extends Piece {

    public Rook(char symbol, String color) {
        super(symbol, color);
    }

    @Override
    public boolean isValidMove(String source, String target, ChessBoard board) {
        char sourceCol = source.charAt(0);
        char targetCol = target.charAt(0);
        int sourceRow = source.charAt(1) - '0';
        int targetRow = target.charAt(1) - '0';

        // 가로 또는 세로로만 이동 가능
        if (sourceCol == targetCol || sourceRow == targetRow) {
            return isPathClear(source, target, board);
        }
        return false;
    }

    private boolean isPathClear(String source, String target, ChessBoard board) {
        // 경로에 장애물이 있는지 확인하는 로직 추가
        char sourceCol = source.charAt(0);
        char targetCol = target.charAt(0);
        int sourceRow = source.charAt(1) - '0';
        int targetRow = target.charAt(1) - '0';

        // 수직 이동
        if (sourceCol == targetCol) {
            int start = Math.min(sourceRow, targetRow) + 1;
            int end = Math.max(sourceRow, targetRow);
            for (int i = start; i < end; i++) {
                if (board.getPieceAt(sourceCol + String.valueOf(i)) != null) {
                    return false;
                }
            }
        }

        // 수평 이동
        if (sourceRow == targetRow) {
            char start = (char) (Math.min(sourceCol, targetCol) + 1);
            char end = (char) Math.max(sourceCol, targetCol);
            for (char i = start; i < end; i++) {
                if (board.getPieceAt(i + String.valueOf(sourceRow)) != null) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public double getScore(Map<String, Piece> board) {
        return 5.0;
    }
}
