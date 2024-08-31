import model.ChessBoard;
import view.InputView;
import view.ResultView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        ChessBoard chessBoard = new ChessBoard();

        System.out.println("체스 게임을 시작합니다.");
        System.out.println("게임 시작은 start, 종료는 end 명령을 입력하세요.");

        while (true) {
            String command = inputView.inputCommand();

            if (command.equals("start")) {
                chessBoard.initialize();
                resultView.printChessBoard(chessBoard);
                System.out.println();  // 체스판 출력 후 줄 바꿈
            }

            if (command.equals("end")) {
                break;
            }
        }
    }
}
