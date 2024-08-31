package controller;

import model.ChessBoard;
import model.Piece;

public class ChessGame {
    private final ChessBoard board;

    public ChessGame() {
        this.board = new ChessBoard();
    }

    public boolean move(String source, String target) {
        if (!isValidPosition(source) || !isValidPosition(target)) {
            System.out.println("유효하지 않은 위치입니다. 체스판 내의 위치를 입력하세요.");
            return false;
        }
        return board.movePiece(source, target);
    }

    public ChessBoard getBoard() {
        return board;
    }

    public boolean isValidPosition(String position) {
        if (position.length() != 2) {
            return false;
        }
        char col = position.charAt(0);
        char row = position.charAt(1);
        return col >= 'a' && col <= 'h' && row >= '1' && row <= '8';
    }

    public boolean isWhitePieceAt(String position) {
        Piece piece = board.getPieceAt(position);
        return piece != null && piece.isWhite();
    }
}
