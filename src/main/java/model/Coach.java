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
}
