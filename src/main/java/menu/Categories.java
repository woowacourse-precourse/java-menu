package menu;

import java.util.Arrays;

public enum Categories {

    No_VALUE(0, ""),
    JAPAN(1, "일식"),
    KOREA(2, "한식"),
    CHINA(3, "중식"),
    ASIAN(4, "아시안"),
    WESTERN(5, "양식");

    private final int number;
    private final String category;

    Categories(int number, String category) {
        this.number = number;
        this.category = category;
    }

    public static Categories of(int randomNumber) {
        return Arrays.stream(Categories.values())
                .filter(state -> state.number == randomNumber)
                .findAny()
                .orElse(No_VALUE);

    }
//
//    public static boolean isUP(String position) {
//        return position.equals(UP.position);
//    }
//
    public String getCategory() {
        return this.category;
    }
}
