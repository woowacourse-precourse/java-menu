package menu.output;

public class InputGuideView {
    private static final String startMessage = "점심 메뉴 추천을 시작합니다.";
    private static final String coachNameInputMessage = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String inedibleFoodsInputMessage = "(이)가 못 먹는 메뉴를 입력해 주세요.";

    public static void printStartMessage() {
        System.out.println(startMessage);
        System.out.println();
        System.out.println(coachNameInputMessage);
    }

    public static void printInputInedibleFoodsMessage(String name) {
        System.out.println();
        System.out.println(name + inedibleFoodsInputMessage);
    }
}
