package menu.domain;

import org.junit.jupiter.api.Test;

class MenuTest {

    @Test
    void from() {
        Menu menu = Menu.from("오코노미야끼");
        System.out.println(menu.name());
    }
}