package menu.view;


import menu.model.Member;
import menu.model.Menu;
import menu.model.MenuCategory;

import java.util.List;

public class OutputView {
    private static final String TABLE_FORMAT = "[ %s | %s | %s | %s | %s | %s ]";

    public void printMessage(Message message) {
        System.out.println(message.getMessage());
    }

    public void printError(IllegalArgumentException e) {
        System.out.println("[ERROR] " + e.getMessage());
    }

    public void printFormatMessage(Message format, String value) {
        System.out.printf(format.getMessage(), value);
        printNewLine();
    }

    public void printHeader() {
        System.out.printf(TABLE_FORMAT,
                "구분",
                Day.MON.getKorean(),
                Day.TUES.getKorean(),
                Day.WED.getKorean(),
                Day.THURS.getKorean(),
                Day.FRI.getKorean());
        printNewLine();
    }

    public void printCategory(List<MenuCategory> categories) {
        System.out.printf(TABLE_FORMAT,
                "카테고리",
                categories.get(0).getKorean(),
                categories.get(1).getKorean(),
                categories.get(2).getKorean(),
                categories.get(3).getKorean(),
                categories.get(4).getKorean());
        printNewLine();
    }

    public void printRecommend(Member member) {
        List<Menu> menus = member.getEatHistory();
        System.out.printf(TABLE_FORMAT,
                member.getName(),
                menus.get(0).getName(),
                menus.get(1).getName(),
                menus.get(2).getName(),
                menus.get(3).getName(),
                menus.get(4).getName());
        printNewLine();
    }


    private void printNewLine() {
        System.out.println();
    }
}
