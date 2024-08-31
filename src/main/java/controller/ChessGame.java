package controller;

import model.ChessBoard;

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
}
