package menu.view;

import static menu.constant.MessageConstant.MESSAGE_OUTPUT_START;

public class OutputView {
    /**
     * 게임 시작 문구를 출력 한다.
     */
    public void printStart() {
        System.out.println(MESSAGE_OUTPUT_START);
    }

    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

}
