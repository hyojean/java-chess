package model;

import java.util.ArrayList;
import java.util.List;

public class ChessBoard {
    private final List<String> board;

    public ChessBoard() {
        board = new ArrayList<>();
    }

    public void initialize() {
        board.clear();
        board.add("RNBQKBNR");
        board.add("PPPPPPPP");
        for (int i = 0; i < 4; i++) {
            board.add("........");
        }
        board.add("pppppppp");
        board.add("rnbqkbnr");
    }

    public List<String> getBoard() {
        return board;
    }
}
