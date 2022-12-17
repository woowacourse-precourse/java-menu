package model;

import java.util.List;

public class Coach {
    
    private static final String INEDIBLE_MENU_SIZE_EXCEPTION = "못 먹는 메뉴는 최대 2개 까지 입력해야 합니다.";
    private static final String LESS_THAN_LENGTH_EXCEPTION = "코치의 이름은 최소 2글자로 입력해야 합니다.";
    private static final String GREATER_THAN_LENGTH_EXCEPTION = "코치의 이름은 최대 4글자로 입력해야 합니다.";
    private static final int MAX_SIZE = 2;
    private final String name;
    private List<String> inedibleMenus;
    
    public Coach(String name) {
        validLength(name);
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    private void validLength(String name) {
        validLessThanLength(name);
        validGreaterThanLength(name);
    }
    
    private void validLessThanLength(String name) {
        int nameLength = name.length();
        if (nameLength < MAX_SIZE) {
            throw new IllegalArgumentException(LESS_THAN_LENGTH_EXCEPTION);
        }
    }
    
    private void validGreaterThanLength(String name) {
        int nameLength = name.length();
        if (nameLength > 4) {
            throw new IllegalArgumentException(GREATER_THAN_LENGTH_EXCEPTION);
        }
    }
    
    public void addInedibleMenus(List<String> inedibleMenus) {
        validLessThanSize(inedibleMenus);
        validInedibleMenus(inedibleMenus);
        this.inedibleMenus = inedibleMenus;
    }
    
    private void validLessThanSize(List<String> inedibleMenus) {
        int inedibleMenusSize = inedibleMenus.size();
        if (inedibleMenusSize > MAX_SIZE) {
            throw new IllegalArgumentException(INEDIBLE_MENU_SIZE_EXCEPTION);
        }
    }
    
    private void validInedibleMenus(List<String> inedibleMenus) {
        for (String inedibleMenu : inedibleMenus) {
            Category.findByMenu(inedibleMenu);
        }
    }
    
    boolean isContains(String menu) {
        return inedibleMenus.contains(menu);
    }
}
