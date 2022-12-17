package menu.output;

import menu.message.InputGuideMessage;

public class InputGuideView {
    public static void printStartMessage() {
        System.out.println(InputGuideMessage.START_MESSAGE.getMessage());
        System.out.println();
        System.out.println(InputGuideMessage.COACH_NAME_INPUT_MESSAGE.getMessage());
    }

    public static void printInputInedibleFoodsMessage(String name) {
        System.out.println();
        System.out.println(name + InputGuideMessage.INEDIBLE_FOODS_INPUT_MESSAGE.getMessage());
    }
}
