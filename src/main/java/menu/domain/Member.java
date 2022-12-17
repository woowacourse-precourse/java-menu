package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private List<String> notEat = new ArrayList<>();
    private List<String> weekEat = new ArrayList<>();

    public Member(String name, List<String> notEat) {
        this.name = name;
        this.notEat = notEat;
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

    public void addWeekEat(String menu) {
        weekEat.add(menu);
    }
}
