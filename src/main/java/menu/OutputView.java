package menu;

import java.util.List;

public class OutputView {

    public void printResult() {
        System.out.println(OutputMessage.RESULT.get());
    }

    public void printFinish() {
        System.out.println(OutputMessage.FINISH.get());
    }

    public void printClassification() {
        System.out.print(OutputMessage.HEAD.get());
        System.out.print(OutputMessage.CLASSIFICATION.get());
        System.out.print(OutputMessage.MIDDLE.get());
        System.out.print(OutputMessage.MON.get());
        System.out.print(OutputMessage.MIDDLE.get());
        System.out.print(OutputMessage.TUE.get());
        System.out.print(OutputMessage.MIDDLE.get());
        System.out.print(OutputMessage.WED.get());
        System.out.print(OutputMessage.MIDDLE.get());
        System.out.print(OutputMessage.THU.get());
        System.out.print(OutputMessage.MIDDLE.get());
        System.out.print(OutputMessage.FRI.get());
        System.out.println(OutputMessage.TAIL.get());
    }

    public void printCategory(List<String> category) {
        System.out.print(OutputMessage.HEAD.get());
        System.out.print(OutputMessage.CATEGORY.get());
        for (String s : category) {
            System.out.print(OutputMessage.MIDDLE.get() + s);
        }
        System.out.println(OutputMessage.TAIL.get());
    }

    public void coachMenu(String coach, List<String> menu) {
        System.out.print(OutputMessage.HEAD.get() + coach);
        for (String s : menu) {
            System.out.print(OutputMessage.MIDDLE.get() + s);
        }
        System.out.println(OutputMessage.TAIL.get());
    }
}

enum OutputMessage {

    RESULT("메뉴 추천 결과입니다."),
    FINISH("추천을 완료했습니다."),

    CLASSIFICATION("구분"),
    CATEGORY("카테고리"),
    MON("월요일"),
    TUE("화요일"),
    WED("수요일"),
    THU("목요일"),
    FRI("금요일"),

    HEAD(" [ "),
    MIDDLE(" | "),
    TAIL(" ] ");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
