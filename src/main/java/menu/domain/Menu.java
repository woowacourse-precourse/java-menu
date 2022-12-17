package menu.domain;

import menu.Utils.Utils;

public class Menu {
    private final String name;
    private final Style style;

    public Menu(String name, int categoryNum) {
        this.name = name;
        this.style = Utils.styleToCategoryConverter(categoryNum);
    }
}
