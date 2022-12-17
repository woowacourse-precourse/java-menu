package menu.model;

public class Category {
    private int number;
    private String name;

    public static String getName(int number) {
        if (number == 1) {
            return "일식";
        }
        if (number == 2) {
            return "한식";
        }
        if (number == 3) {
            return "중식";
        }
        if (number == 4) {
            return "아시안";
        }
        return "양식";
    }
}
