import controller.ChessGame;
import view.InputView;
import view.ResultView;

public class Application {
    public static void main(String[] args) {
        ChessGame game = new ChessGame();
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        boolean isGameStarted = false;
        boolean isWhiteTurn = true;

        System.out.println("> 체스 게임을 시작합니다.");
        System.out.println("> 게임 시작 : start");
        System.out.println("> 게임 종료 : end");
        System.out.println("> 게임 이동 : move source위치 target위치 - 예. move b2 b3");

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
                    if (!game.isValidPosition(moveCommand[1]) || !game.isValidPosition(moveCommand[2])) {
                        System.out.println("유효하지 않은 위치입니다. 다시 입력하세요.");
                        continue;
                    }
                    if (isWhiteTurn && game.isWhitePieceAt(moveCommand[1])) {
                        boolean isValid = game.move(moveCommand[1], moveCommand[2]);
                        if (isValid) {
                            resultView.printChessBoard(game.getBoard());
                            isWhiteTurn = false;
                        } else {
                            resultView.printInvalidMove();
                        }
                    } else if (!isWhiteTurn && !game.isWhitePieceAt(moveCommand[1])) {
                        boolean isValid = game.move(moveCommand[1], moveCommand[2]);
                        if (isValid) {
                            resultView.printChessBoard(game.getBoard());
                            isWhiteTurn = true;
                        } else {
                            resultView.printInvalidMove();
                        }
                    } else {
                        System.out.println("잘못된 차례입니다.");
                    }
                } else {
                    resultView.printInvalidMove();
                }
            } else if (command.equals("end")) {
                break;
            } else {
                System.out.println("알 수 없는 명령입니다. 다시 입력하세요.");
            }
        }
    }
}
