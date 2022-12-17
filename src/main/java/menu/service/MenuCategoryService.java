package menu.service;

import menu.model.MenuCategory;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author : jeeseob
 * @CreateAt : 2022/12/17
 */
public class MenuCategoryService {
    public MenuCategory getRandomMenuCategory() {
        List<MenuCategory> menuCategories = Arrays.stream(MenuCategory.values()).collect(Collectors.toList());
        return menuCategories.get(Randoms.pickNumberInRange(1, menuCategories.size()) - 1);
    }
}
