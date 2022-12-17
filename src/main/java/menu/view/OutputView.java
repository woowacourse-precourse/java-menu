package menu.view;

public class OutputView {

    private static final String START_PHRASE = "점심 메뉴 추천을 시작합니다.+\n";

    public static void printPhrase(String phrase) {
        System.out.println(phrase);
    }

    // 시작 문구 출력 기능
    public static void printStart() {
        System.out.println(START_PHRASE);
    }
}
