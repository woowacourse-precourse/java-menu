package menu.service;

import menu.model.MenuCategory;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @Author : jeeseob
 * @CreateAt : 2022/12/17
 */
public class MenuCategoryService {
    public MenuCategory getRandomMenuCategory() {
       return Arrays.stream(MenuCategory.values()).collect(Collectors.toList())
               .get(Randoms.pickNumberInRange(1, MenuCategory.values().length));
    }
}
