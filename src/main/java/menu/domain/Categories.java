package menu.domain;

import java.util.Arrays;
import java.util.List;
import menu.utils.CSVUtils;

public enum Categories {
    JAPANESE(1, "일식"),
    KOREAN(2, "한식"),
    CHINESE(3, "중식"),
    ASIAN(4, "아시안"),
    WESTERN(5, "양식");

    private final int categoryCode;
    private final String categoryName;
    private List<String> menu;

    Categories(int categoryCode, String categoryName){
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        initMenu(categoryName);
    }

    private void initMenu(String categoryName){
        this.menu = CSVUtils.getCsvLine(this.categoryName);
    }

    public static Categories get(int categoryCode){
        return Arrays.stream(Categories.values())
                .filter(category -> category.getCategoryCode() == categoryCode)
                .findAny().get();
    }

    private int getCategoryCode(){
        return this.categoryCode;
    }

    public List<String> getMenu(){
        return this.menu;
    }
}
