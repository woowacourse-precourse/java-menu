package menu;

import java.util.List;

public class OutputView {
    private final static String LINE_START = "[ ";
    private final static String LINE_END = " ]";

    public void printServiceIntro(){
        System.out.println(GuidanceMessage.SERVICE_INTRO);
        System.out.println();
    }

    // 파라미터 필요함
    public void printLine(){

    }

    private void printEachLine(){
        System.out.println(LINE_START);
        //each line
        System.out.println(LINE_END);
    }

    public void printResult(){
        System.out.println(GuidanceMessage.SERVICE_RESULT);
        printLine();
        System.out.println();
        System.out.println(GuidanceMessage.SERVICE_OUTRO);
    }

    public void printError(IllegalArgumentException e){
        System.out.println(ErrorMessage.PREFIX);
        System.out.println(e.getMessage());
    }
}
