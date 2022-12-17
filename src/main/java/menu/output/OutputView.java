package menu.output;

public class OutputView {
    private static final String startMessage = "점심 메뉴 추천을 시작합니다.\n";
    private static final String inputCoachMessage = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String inputMenuMessage = "(이)가 못 먹는 메뉴를 입력해 주세요.\n";
    private static final String resultStartMessage = "메뉴 추천 결과입니다.\n";
    private static final String endMessage = "추천을 완료했습니다.";

    public void printStart() {
        System.out.println(startMessage);
    }

    public void printCoachMessage() {
        System.out.println(inputCoachMessage);
    }

    public void printMenuMessage(String coachName) {
        String message = coachName + inputMenuMessage;
        System.out.println(message);
    }

}
