package menu.domain;


import java.util.List;

public class Coach {
    private final String name;
    private List<String> blacklist;

    public Coach(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException("코치의 이름은 2~4글자여야 합니다.");
        }
    }

    public void setBlacklist(List<String> blacklist) {
        validateBlacklist(blacklist);
        this.blacklist = blacklist;
    }

    private void validateBlacklist(List<String> blacklist) {
        if (blacklist.size() > 2){
            throw new IllegalArgumentException("못 먹는 메뉴는 2가지까지만 가능합니다");
        }
    }

    public String getName() {
        return name;
    }
}
