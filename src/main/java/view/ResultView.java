package view;

import model.ChessBoard;
import model.Piece;

public class ResultView {
    public void printChessBoard(ChessBoard chessBoard) {
        for (int row = 8; row >= 1; row--) {
            for (char col = 'a'; col <= 'h'; col++) {
                String position = col + String.valueOf(row);
                Piece piece = chessBoard.getPieceAt(position);
                if (piece != null) {
                    System.out.print(piece.getSymbol());
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printInvalidMove() {
        System.out.println("유효하지 않은 이동입니다. 다시 입력하세요.");
    }
}
