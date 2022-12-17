package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.controller.MainController;
import menu.domain.Categories;
import menu.domain.CategoryEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RandomService {

    public List<String> randomGetCategory() {
        List<String> resultCategories = new ArrayList<>();

        while (resultCategories.size() != 5) {
            int categoryNum = Randoms.pickNumberInRange(1, 5);
            String result = transferCategory(categoryNum);
            if (resultCategories.stream().filter(name -> name.equals(result)).count() < 2) {
                resultCategories.add(result);
            }
        }

        return resultCategories;
    }

    private String transferCategory(int val) {
        return CategoryEnum.getTransferCategoryName(val);
    }

    public List<String> randomGetMenu(String category, List<String> names) {
        List<String> result = new ArrayList<>();
        List<String> categoryMenu = Categories.getCategory(category);

        names.forEach(name -> {
            List<String> hate = MainController.people.get(name);
            List<String> canEatFood = categoryMenu.stream()
                    .filter(menu -> !hate.contains(menu))
                    .collect(Collectors.toList());
            String resultRandom = Randoms.shuffle(canEatFood).get(0);
            result.add(resultRandom);
            MainController.people.get(name).add(resultRandom);
        });

        return result;
    }
}
