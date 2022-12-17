package menu.view;

import menu.domain.ResultList;
import menu.utils.Constants;

public class OutputView {

    public void printResult(ResultList resultList) {
        System.out.println(resultList);
    }

    public void print(Constants message) {
        System.out.println(message.getConstants());
    }

}
