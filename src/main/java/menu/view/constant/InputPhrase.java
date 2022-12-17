package menu.view.constant;

public enum InputPhrase {
    COACH_INPUT("코치의 이름을 입력해 주세요. (, 로 구분)"),
    COACH_PREFERENCE("%s(이)가 못 먹는 메뉴를 입력해 주세요.");

    private final String phrase;

    InputPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String getPhrase() {
        return phrase;
    }
}
