package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import menu.enums.Category;

public class Recommender {

    public static String recommendMenu(Category category) {
        // 메뉴 리스트를 List<String>으로 받아와서 추첨
        List<String> menus = category.getRepository().foods().stream()
                .map(Food::getName)
                .collect(Collectors.toList());
        return Randoms.shuffle(menus).get(0);
    }

    public static Category recommendCategory() {
        return Category.from(Randoms.pickNumberInRange(1, 5));
    }
}