package controller;

import model.ChessBoard;
import model.Piece;

public class ChessGame {
    private final ChessBoard board;

    public ChessGame() {
        this.board = new ChessBoard();
    }

    public ChessBoard getBoard() {
        return board;
    }

    public boolean move(String source, String target) {
        Piece targetPiece = board.getPieceAt(target);
        boolean moved = board.movePiece(source, target);
        if (moved && targetPiece != null && targetPiece.isKing()) {
            System.out.println("킹이 잡혔습니다. 게임이 종료됩니다.");
            System.exit(0); // 게임 종료
        }
        return moved;
    }

    public boolean isWhitePieceAt(String position) {
        Piece piece = board.getPieceAt(position);
        return piece != null && piece.getColor().equals("white");
    }

    public double calculateScore(String color) {
        return board.calculateScore(color);
    }

    public String getGameStatus() {
        double whiteScore = calculateScore("white");
        double blackScore = calculateScore("black");

        String result = "백팀 점수: " + whiteScore + "\n" +
                "흑팀 점수: " + blackScore + "\n";

        if (whiteScore > blackScore) {
            result += "백팀이 이겼습니다!";
        } else if (blackScore > whiteScore) {
            result += "흑팀이 이겼습니다!";
        } else {
            result += "무승부입니다!";
        }

        return result;
    }
}
