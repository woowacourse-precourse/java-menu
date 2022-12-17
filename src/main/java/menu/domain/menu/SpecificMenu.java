package menu.domain.menu;

import menu.domain.FoodCategory;

import java.util.List;

public interface SpecificMenu {

    boolean isContain(String foodName);

    List<String> getFoodsList();
}
