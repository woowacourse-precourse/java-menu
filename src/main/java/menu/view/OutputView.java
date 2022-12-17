package menu.view;

import java.util.List;
import javax.xml.parsers.SAXParser;
import menu.domain.Coach;
import menu.domain.Day;
import menu.utils.Message;

public class OutputView {

    private static final String START = "[ ";
    private static final String END = " ]";
    private static final String SEPARATOR = " | ";

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printStart() {
        System.out.println(Message.START);
    }

    public static void printResult(List<String> recomandedCategory, List<Coach> coaches) {
        System.out.println(Message.RESULT);
        System.out.println(START + "구분");
        System.out.print(String.join(SEPARATOR, Day.getDayValueList()));
        System.out.println(END);
        for (Coach coach : coaches) {
            System.out.print(START + coach.getName());
            for (String menu : coach.getRecomandedMenu()) {
                System.out.print(SEPARATOR);
                System.out.print(menu);
            }
        }
        System.out.println();
        System.out.println(Message.FINISH);
    }
}
