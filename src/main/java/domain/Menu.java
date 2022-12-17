package domain;

import java.io.IOException;
import java.util.Objects;

public class Menu {
    private final String name;

    public Menu(String name) throws IOException {
        this.name = name;
    }

//    private void validateExistMenu(String name) throws IOException {
//        MenuByCategoryData menuByCategoryData = new MenuByCategoryData();
//        if (menuByCategoryData.hasMenu(name)) {
//            return;
//        }
//        throw new IllegalArgumentException("[ERROR] 존재하지 않는 메뉴입니다.");
//    }


    public String getName() {
        return name;
    }



    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        Menu menu = (Menu) o;

        return name.equals(menu.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
