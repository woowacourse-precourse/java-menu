package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Coach {
    private static final int LENGTH_LOEWR = 2;
    private static final int LENGTH_UPPER = 4;
    private final String name;
    private final List<String> notEatingMenus = new ArrayList<>();
    private final List<String> recommandMenus = new ArrayList<>();
    public boolean flag = false;

    public Coach(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        int nameLength = name.length();
        if (nameLength < LENGTH_LOEWR || nameLength > LENGTH_UPPER) {
            throw new IllegalArgumentException("[ERROR] 이름 길이는 2부터 4글자 까지 입니다.");
        }
    }

    public void addNotEatingMenu(String menu) {
        validateNotEatingMenu(menu);
        notEatingMenus.add(menu);
    }

    private void validateNotEatingMenu(String menu) {
        if (notEatingMenus.size() == 2) {
            throw new IllegalArgumentException("[ERROR] 못먹는 음식은 최대 2개 까지 입니다.");
        }
        if (notEatingMenus.size() != 0 && notEatingMenus.contains(menu)) {
            throw new IllegalArgumentException("[ERROR] 못먹는 음식이 중복 되었습니다");
        }
    }

    public void addRecommandMenu(String menu) {
        validateCategory(menu);
        validateRecommandMenu(menu);
        recommandMenus.add(menu);
    }

    private void validateRecommandMenu(String menu) {
        if (recommandMenus.size() != 0 && recommandMenus.contains(menu)) {
            throw new IllegalArgumentException("[ERROR] 중복 메뉴 입니다");
        }
        if (notEatingMenus.size() != 0 && notEatingMenus.contains(menu)) {
            throw new IllegalArgumentException("[ERROR] 먹지 못하는 메뉴 입니다.");
        }
    }

    private void validateCategory(String menu) {
        List<Category> categories = new ArrayList<>();
        int count = 0;
        if (recommandMenus.size() != 0) {
            for (String recommandMenu : recommandMenus) {
                categories.add(Category.of(recommandMenu));
            }
            count = Collections.frequency(categories, Category.of(menu));
        }
        if (count == 2) {
            flag= true;
            throw new IllegalArgumentException("[ERROR] 해당 카테고리가 2개 이상");
        }
    }

    public String getName() {
        return name;
    }

    public boolean isSameName(String name) {
        return this.name == name;
    }

    public List<String> getCategoryNames() {
        List<String> categoryNames = new ArrayList<>();
        for (String recommandMenu : recommandMenus) {
            categoryNames.add(Category.of(recommandMenu).getName());
        }
        return categoryNames;
    }

    public List<String> getRecommandMenus() {
       return recommandMenus;
    }

    public boolean isFull(){
        return recommandMenus.size() == 5;
    }


}
