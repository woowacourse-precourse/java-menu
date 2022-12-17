package model;

import java.util.List;

public class Coach {
    
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
    
    public void addInedibleMenus(List<String> inedibleMenus) {
        validLessThanSize(inedibleMenus);
        this.inedibleMenus = inedibleMenus;
    }
    
    private void validLessThanSize(List<String> inedibleMenus) {
        int inedibleMenusSize = inedibleMenus.size();
        if (inedibleMenusSize > 2) {
            throw new IllegalArgumentException("못 먹는 메뉴는 최대 2개 까지 입력해야 합니다.");
        }
    }
    
    public boolean isContains(String menu) {
        return inedibleMenus.contains(menu);
    }
}
