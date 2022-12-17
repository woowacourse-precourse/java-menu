package menu.view;

import menu.domain.Result;
import menu.util.PrintMsg;

public class OutputView {
    public void printMsg(String msg) {
        System.out.println(msg);
    }

    public void printEmptyMsg() {
        System.out.println();
    }

    public void printService(Result result) {
        printMsg(PrintMsg.RESULT.getMsg());
        printMsg(result.divisionToString());
        printMsg(result.categoriToString());
        for (String menuInfo : result.getCoachResult()) {
            printMsg(menuInfo);
        }
        printEmptyMsg();
        printMsg(PrintMsg.END.getMsg());
    }
}
