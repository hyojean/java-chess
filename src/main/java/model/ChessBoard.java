package model;

import java.util.HashMap;
import java.util.Map;

public class ChessBoard {
    private final Map<String, Piece> board;

    public ChessBoard() {
        board = new HashMap<>();
    }

    public void initialize() {
        // 체스판 초기화
        board.clear();

        // 백팀 말 배치
        board.put("a1", new Rook('r', "white"));
        board.put("b1", new Knight('n', "white"));
        board.put("c1", new Bishop('b', "white"));
        board.put("d1", new Queen('q', "white"));
        board.put("e1", new King('k', "white"));
        board.put("f1", new Bishop('b', "white"));
        board.put("g1", new Knight('n', "white"));
        board.put("h1", new Rook('r', "white"));
        for (char c = 'a'; c <= 'h'; c++) {
            board.put(c + "2", new Pawn('p', "white"));
        }

        // 흑팀 말 배치
        board.put("a8", new Rook('R', "black"));
        board.put("b8", new Knight('N', "black"));
        board.put("c8", new Bishop('B', "black"));
        board.put("d8", new Queen('Q', "black"));
        board.put("e8", new King('K', "black"));
        board.put("f8", new Bishop('B', "black"));
        board.put("g8", new Knight('N', "black"));
        board.put("h8", new Rook('R', "black"));
        for (char c = 'a'; c <= 'h'; c++) {
            board.put(c + "7", new Pawn('P', "black"));
        }
    }

    public Piece getPieceAt(String position) {
        return board.get(position);
    }

    public boolean movePiece(String source, String target) {
        Piece piece = board.get(source);
        if (piece == null || !piece.isValidMove(source, target, this)) {
            return false;
        }

        board.put(target, piece);
        board.remove(source);
        return true;
    }

    public Map<String, Piece> getBoard() {
        return board;
    }

    public double calculateScore(String color) {
        double score = 0.0;
        for (Piece piece : board.values()) {
            if (piece.getColor().equals(color)) {
                score += piece.getScore(board);
            }
        }
        return score;
    }
}
