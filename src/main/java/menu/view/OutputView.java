package menu.view;

import menu.utils.OutputMessage;

public class OutputView {

    public void printInitRecommend() {
        System.out.println(OutputMessage.INIT_PROGRAM);
    }

    public void printReadCouchName() {
        System.out.println(OutputMessage.INPUT_COUCH_NAME);
    }

    public void printResult() {
        System.out.println(OutputMessage.RECOMMEND_RESULT);
        // TODO : 구분, 카테고리, 각 코치별 정해진 메뉴 출력
    }
}
