package model;

import java.util.List;

public class Coach {
    
    private final String name;
    private List<String> canNotEatMenus;
    
    public Coach(String name) {
        validLength(name);
        this.name = name;
    }
    
    private void validLength(String name) {
        validLessThanLength(name);
        validGreaterThanLength(name);
    }
    
    private void validLessThanLength(String name) {
        int nameLength = name.length();
        if (nameLength < 2) {
            throw new IllegalArgumentException("코치의 이름은 최소 2글자로 입력해야 합니다.");
        }
    }
    
    private void validGreaterThanLength(String name) {
        int nameLength = name.length();
        if (nameLength > 4) {
            throw new IllegalArgumentException("코치의 이름은 최대 4글자로 입력해야 합니다.");
        }
    }
    
    public void addCanNotEatMenus(List<String> canNotEatMenus) {
        validLessThanSize(canNotEatMenus);
        this.canNotEatMenus = canNotEatMenus;
    }
    
    private void validLessThanSize(List<String> canNotEatMenus) {
        int canNotEatMenusSize = canNotEatMenus.size();
        if (canNotEatMenusSize > 2) {
            throw new IllegalArgumentException("못 먹는 메뉴는 최대 2개 까지 입력해야 합니다.");
        }
    }
}
