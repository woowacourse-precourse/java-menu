package menu.domain.categories;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Stream;

public abstract class AbstractCategory {
    public final List<String> menus;

    public AbstractCategory(List<String> menus) {
        this.menus = menus;
    }

    public Stream<String> getMenus() {
        return menus.stream();
    }

    public String pickMenu() {
        return Randoms.shuffle(menus).get(0);
    }
}
