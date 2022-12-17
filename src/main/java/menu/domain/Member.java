package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private List<String> notEat = new ArrayList<>();
    private List<String> weekEat = new ArrayList<>();

    public Member(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<String> getNotEat() {
        return notEat;
    }

    public List<String> getWeekEat() {
        return weekEat;
    }
}
