package menu.domain;

import menu.utils.Utils;

public class Menu {
    private final String name;
    private final Style style;

    public Menu(String name, int categoryNum) {
        this.name = name;
        this.style = Utils.styleToCategoryConverter(categoryNum);
    }

    public String getName() {
        return name;
    }

    public Style getStyle() {
        return style;
    }
}
