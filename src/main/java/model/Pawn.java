package model;

public class Pawn extends Piece {

    public Pawn(char symbol, String color) {
        super(symbol, color);
    }

    @Override
    public boolean isValidMove(String source, String target, ChessBoard board) {
        int sourceRow = source.charAt(1) - '0';
        int targetRow = target.charAt(1) - '0';
        char sourceCol = source.charAt(0);
        char targetCol = target.charAt(0);

        int direction = this.getColor().equals("white") ? 1 : -1;

        // 일반 전진 (한 칸)
        if (sourceCol == targetCol && targetRow == sourceRow + direction) {
            return board.getPieceAt(target) == null;
        }

        // 첫 이동 시 전진 (두 칸)
        if (sourceCol == targetCol && sourceRow == (this.getColor().equals("white") ? 2 : 7) && targetRow == sourceRow + 2 * direction) {
            return board.getPieceAt(target) == null && board.getPieceAt(sourceCol + String.valueOf(sourceRow + direction)) == null;
        }

        // 대각선 이동 (공격)
        if (Math.abs(sourceCol - targetCol) == 1 && targetRow == sourceRow + direction) {
            return board.getPieceAt(target) != null && !board.getPieceAt(target).getColor().equals(this.getColor());
        }

        return false;
    }
}
