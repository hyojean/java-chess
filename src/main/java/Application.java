import controller.ChessGame;
import view.InputView;
import view.ResultView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3307/chessdb"; // 데이터베이스 URL
        String user = "root"; // MySQL 사용자 이름
        String password = "root"; // MySQL 비밀번호

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            ChessGame game = new ChessGame(connection);
            InputView inputView = new InputView();
            ResultView resultView = new ResultView();
            boolean isGameStarted = false;

            System.out.println("> 체스 게임을 시작합니다.");
            System.out.println("> 게임 시작 : start");
            System.out.println("> 게임 종료 : end");
            System.out.println("> 게임 이동 : move source위치 target위치 - 예. move b2 b3");
            System.out.println("> 점수 확인 : status");

            if (game.hasSavedGame()) {
                System.out.println("이전 게임이 있습니다. 불러오시겠습니까? (y/n)");
                Scanner scanner = new Scanner(System.in);
                String response = scanner.nextLine();

                if (response.equalsIgnoreCase("y")) {
                    game.loadGame();
                    resultView.printChessBoard(game.getBoard());
                    isGameStarted = true;
                }
            }

            while (true) {
                String command = inputView.inputCommand();

                if (command.equals("start")) {
                    game.getBoard().initialize();
                    resultView.printChessBoard(game.getBoard());
                    isGameStarted = true;
                } else if (command.startsWith("move")) {
                    if (!isGameStarted) {
                        System.out.println("게임을 시작하세요.");
                        continue;
                    }
                    String[] moveCommand = command.split(" ");
                    if (moveCommand.length == 3) {
                        if (game.isWhiteTurn() && game.isWhitePieceAt(moveCommand[1])) {
                            boolean isValid = game.move(moveCommand[1], moveCommand[2]);
                            if (isValid) {
                                resultView.printChessBoard(game.getBoard());
                            } else {
                                resultView.printInvalidMove();
                            }
                        } else if (!game.isWhiteTurn() && !game.isWhitePieceAt(moveCommand[1])) {
                            boolean isValid = game.move(moveCommand[1], moveCommand[2]);
                            if (isValid) {
                                resultView.printChessBoard(game.getBoard());
                            } else {
                                resultView.printInvalidMove();
                            }
                        } else {
                            System.out.println("잘못된 차례입니다.");
                        }
                    } else {
                        resultView.printInvalidMove();
                    }
                } else if (command.equals("status")) {
                    System.out.println(game.getGameStatus());
                } else if (command.equals("end")) {
                    game.saveGame();
                    break;
                } else {
                    System.out.println("알 수 없는 명령입니다. 다시 입력하세요.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
