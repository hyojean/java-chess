package view;

import model.ChessBoard;

public class ResultView {
    public void printChessBoard(ChessBoard chessBoard) {
        for (String row : chessBoard.getBoard()) {
            System.out.println(row);
        }
    }
}
