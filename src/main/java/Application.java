import controller.ChessGame;
import view.InputView;
import view.ResultView;

public class Application {
    public static void main(String[] args) {
        ChessGame game = new ChessGame();
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        System.out.println("> 체스 게임을 시작합니다.");
        System.out.println("> 게임 시작 : start");
        System.out.println("> 게임 종료 : end");
        System.out.println("> 게임 이동 : move source위치 target위치 - 예. move b2 b3");

        while (true) {
            String command = inputView.inputCommand();

            if (command.equals("start")) {
                game.getBoard().initialize();
                resultView.printChessBoard(game.getBoard());
            } else if (command.startsWith("move")) {
                String[] moveCommand = command.split(" ");
                if (moveCommand.length == 3) {
                    boolean isValid = game.move(moveCommand[1], moveCommand[2]);
                    if (isValid) {
                        resultView.printChessBoard(game.getBoard());
                    } else {
                        resultView.printInvalidMove();
                    }
                } else {
                    resultView.printInvalidMove();
                }
            } else if (command.equals("end")) {
                break;
            } else {
                System.out.println("알 수 없는 명령입니다. 다시 시도하세요.");
            }
        }
    }
}
