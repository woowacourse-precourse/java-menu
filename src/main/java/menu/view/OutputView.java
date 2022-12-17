package menu.view;

/**
 * @Author : jeeseob
 * @CreateAt : 2022/12/17
 */
public class OutputView {
    private static final String START_RECOMMEND_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String INPUT_COACH_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String INPUT_HATE_MENU = "(이)가 못 먹는 메뉴를 입력해 주세요.";
    private static final String RESULT_RECOMMEND_MESSAGE = "메뉴 추천 결과입니다.";
    private static final String FINISH_RECOMMEND_MESSAGE = "추천을 완료했습니다.";



    public void printStartMessage() {
        System.out.println(START_RECOMMEND_MESSAGE);
    }

    public void printCoachNameMessage() {
        System.out.println(INPUT_COACH_NAME);
    }

    public void printInputHateMenuMessage(String name) {
        System.out.println(name + INPUT_HATE_MENU);
    }

    public void printResultMessage() {
        System.out.println(RESULT_RECOMMEND_MESSAGE);
    }

    public void printFinishMessage() {
        System.out.println(FINISH_RECOMMEND_MESSAGE);
    }


}