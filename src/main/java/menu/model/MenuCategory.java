package menu.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum MenuCategory {
    JAPAN(1, "일식"),
    KOREA(2, "한식"),
    CHINA(3, "중식"),
    ASIAN(4, "아시안"),
    AMERICAN(5, "양식");

    private final Integer id;
    private final String korean;
    private static final Map<Integer, MenuCategory> mapping = new HashMap<>();

    MenuCategory(Integer id, String korean) {
        this.id = id;
        this.korean = korean;
    }

    static {
        Arrays.stream(MenuCategory.values())
                .forEach(category -> mapping.put(category.id, category));
    }

    public String getKorean() {
        return korean;
    }

    public static MenuCategory get(Integer id) {
        return mapping.get(id);
    }


}
