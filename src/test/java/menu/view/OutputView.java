package menu.view;

import menu.constant.Message;

public class OutputView {

    public static void printServiceStartMessage(){
        System.out.println(Message.SERVICE_START_MESSAGE);
    }

    public static void printServiceFinishMessage(){
        System.out.println();
        System.out.println(Message.SERVICE_FINISH_MESSAGE);
    }

    public static void printGetCoachNamesMessage(){
        System.out.println();
        System.out.println(Message.GET_COACH_NAMES_MESSAGE);
    }



}
