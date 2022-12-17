package menu.view.constant;

public enum OutputPhrase {
    START("점심 메뉴 추천을 시작합니다."),
    RESULT("메뉴 추천 결과입니다."),
    FINISH("추천을 완료했습니다.");

    private final String phrase;

    OutputPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String getPhrase() {
        return phrase;
    }

}
