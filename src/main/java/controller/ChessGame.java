package controller;

import model.ChessBoard;
import model.Piece;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChessGame {
    private final ChessBoard board;
    private boolean isWhiteTurn;
    private final Connection connection;

    public ChessGame(Connection connection) {
        this.board = new ChessBoard();
        this.isWhiteTurn = true;
        this.connection = connection;
    }

    public ChessBoard getBoard() {
        return board;
    }

    public boolean move(String source, String target) {
        Piece targetPiece = board.getPieceAt(target);
        boolean moved = board.movePiece(source, target);
        if (moved) {
            if (targetPiece != null && targetPiece.isKing()) {
                System.out.println("킹이 잡혔습니다. 게임이 종료됩니다.");
                saveGame(); // 게임 종료 시 저장
                System.exit(0);
            }
            isWhiteTurn = !isWhiteTurn;
            saveGame(); // 움직임이 있을 때마다 저장
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
            result += "백팀이 이겼습니다!\n";
        } else if (blackScore > whiteScore) {
            result += "흑팀이 이겼습니다!\n";
        } else {
            result += "무승부입니다!\n";
        }

        return result;
    }

    public void saveGame() {
        String boardState = board.toString(); // 보드를 문자열로 직렬화
        String currentPlayer = isWhiteTurn ? "white" : "black";

        try (PreparedStatement statement = connection.prepareStatement(
                "REPLACE INTO game_state (id, board_state, current_player) VALUES (1, ?, ?)"
        )) {
            statement.setString(1, boardState);
            statement.setString(2, currentPlayer);
            statement.executeUpdate();
            //System.out.println("게임이 저장되었습니다.");
        } catch (SQLException e) {
            System.out.println("게임 저장 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    public void loadGame() {
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT board_state, current_player FROM game_state WHERE id = 1"
        )) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String boardState = resultSet.getString("board_state");
                String currentPlayer = resultSet.getString("current_player");

                board.initializeFromString(boardState); // 보드를 복원
                isWhiteTurn = currentPlayer.equals("white");
                System.out.println("이전 게임을 불러왔습니다.");
            }
        } catch (SQLException e) {
            System.out.println("이전 게임 불러오기 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    public boolean hasSavedGame() {
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT COUNT(*) FROM game_state WHERE id = 1"
        )) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.out.println("이전 게임 상태 확인 중 오류가 발생했습니다: " + e.getMessage());
        }
        return false;
    }

    public boolean isWhiteTurn() {
        return isWhiteTurn;
    }
}
