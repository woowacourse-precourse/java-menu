package menu.Util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OutputView {
    public static void getInvitation() {
        System.out.println(SystemMessage.Invitation.getMessage());
    }

    public static void getAllergic(String name) {
        System.out.println(name + SystemMessage.Allergy.getMessage());
    }

    public static void printResult() {
        System.out.println(SystemMessage.Final.getMessage());
    }

    public static void printEnd() {
        System.out.println(SystemMessage.End.getMessage());
    }

    public static void printCategory(String cat, List<String> category) {
        List<String> result = new ArrayList<>();
        result.add(cat);
        result.addAll(category);
        formatPrint(result);
    }

    public static void formatPrint(List<String> result) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Iterator<String> iterator = result.listIterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next()).append(" | ");
        }
        String end = sb.substring(0, sb.length() - 3);
        System.out.println(end + " ]");
    }
}
