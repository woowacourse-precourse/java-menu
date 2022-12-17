package menu.output;

public class InputGuideView {
    private static final String startMessage = "점심 메뉴 추천을 시작합니다.";
    private static final String coachNameInputMessage = "코치의 이름을 입력해 주세요. (, 로 구분)";

    public static void printStartMessage() {
        System.out.println(startMessage);
        System.out.println();
        System.out.println(coachNameInputMessage);
    }
}
