package menu.view;

public class Output {
    private static final String NEW_LINE = "\n";

    public void printStart() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void askCoachName() {
        System.out.println(NEW_LINE + "코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public void printError(String message) {
    }
}
