package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Coach {

    private static final int COACH_NAME_MINIMUM_SIZE = 2;
    private static final int COACH_NAME_MAXIMUM_SIZE = 4;
    private static final String NAME_LENGTH_ERROR = "코치 이름은 2~4글자 이내여야 합니다.";
    private static final String NAME_ALPHABETIC_ERROR = "코치 이름은 문자로만 이루어져야 합니다.";
    private final String name;
    private final List<String> selectedMenus = new ArrayList<>();
    private final List<String> inedibleMenus = new ArrayList<>();

    public Coach(String name) {
        validateCoachNameSize(name.trim());
        validateCoachNameAlphabetic(name.trim());
        this.name = name.trim();
    }

    private void validateCoachNameSize(String name) {
        if (name.length() < COACH_NAME_MINIMUM_SIZE || name.length() > COACH_NAME_MAXIMUM_SIZE) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
    }

    private void validateCoachNameAlphabetic(String name){
        for(Character character : name.toCharArray()){
            if(!Character.isAlphabetic(character)){
                throw new IllegalArgumentException(NAME_ALPHABETIC_ERROR);
            }
        }
    }

    public boolean addSelectedMenu(String menu) {
        if (isInedibleMenu(menu) || isSelectedMenu(menu)) {
            return false;
        }
        selectedMenus.add(menu);
        return true;
    }

    public void addInedibleMenus(List<String> menus) {
        inedibleMenus.addAll(menus);
    }

    private boolean isSelectedMenu(String menu) {
        return selectedMenus.contains(menu);
    }

    private boolean isInedibleMenu(String menu) {
        return inedibleMenus.contains(menu);
    }

    public List<String> getSelectedMenu() {
        return Collections.unmodifiableList(selectedMenus);
    }

    public String getName() {
        return name;
    }

}
