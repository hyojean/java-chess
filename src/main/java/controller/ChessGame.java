package controller;

import model.ChessBoard;
import model.Piece;

public class ChessGame {
    private final ChessBoard board;

    public ChessGame() {
        this.board = new ChessBoard();
    }

    public boolean move(String source, String target) {
        return board.movePiece(source, target);
    }

    public ChessBoard getBoard() {
        return board;
    }

    public boolean isWhitePieceAt(String position) {
        Piece piece = board.getPieceAt(position);
        return piece != null && piece.isWhite();
    }
}
