package model;

public class Coach {
    
    private final String name;
    
    public Coach(String name) {
        validLength(name);
        this.name = name;
    }
    
    private void validLength(String name) {
        int nameLength = name.length();
        if (nameLength < 2 || nameLength > 4) {
            throw new IllegalArgumentException("코치의 이름은 최소 2글자, 최대 4글자로 입력해야 합니다.");
        }
    }
}
