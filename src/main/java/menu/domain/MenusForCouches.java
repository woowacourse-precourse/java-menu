package menu.domain;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class MenusForCouches {

    List<MenusForCouch> menusForCouches;

    public MenusForCouches(List<MenusForCouch> menusForCouches) {
        this.menusForCouches = menusForCouches;
    }

    public List<MenusForCouch> getMenusForCouches() {
        return Collections.unmodifiableList(menusForCouches);
    }

    public MenusForCouch getMenusForCouch(Predicate<MenusForCouch> predicate) {
        return menusForCouches.stream().filter(predicate).findAny().get();
    }

}
