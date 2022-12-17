package menu.controller;

import menu.view.InputView;
import menu.view.OutputView;

public class MainController {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public void run() {
        /* 서비스 시작 문구 출력 */
        outputView.printStartMessage();

        /* 사전 준비
        * - 코치 이름 입력 받기
        * - 코치별로 못 먹는 메뉴 입력 받기
        * - 코치 객체 생성 (이름, 못먹는 메뉴 세팅) */

        /* 메뉴 추천 */

        /* 서비스 종료 문구 출력 */
        outputView.printEndMessage();
    }
}
