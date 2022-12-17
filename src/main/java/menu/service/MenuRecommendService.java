package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.MenuRepository;
import java.util.List;

public class MenuRecommendService {
    public static String recommendMenu(String coach, String category) {
        String selectedMenu = pickMenu(category);
        return selectedMenu;
    }

    private static String pickMenu(String category) {
        List<String> targetMenu = MenuRepository.findMenuListByCategory(category);
        return Randoms.shuffle(targetMenu).get(0);
    }
}
