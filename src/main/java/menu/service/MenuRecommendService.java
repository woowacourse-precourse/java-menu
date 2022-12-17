package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.MenuRepository;
import java.util.*;

public class MenuRecommendService {
    /**
     * 코치별 제공되면 안되는 메뉴들의 집합을 저장한다.
     */
    private static final Map<String, Set<String>> bannedMenuByCoach = new HashMap<>();

    public static String recommendMenu(String coach, String category) {
        String selectedMenu;
        do {
            selectedMenu = pickMenu(category);
        } while (isBannedMenu(coach, selectedMenu));
        addBannedMenu(coach, selectedMenu); // 제공된 메뉴 재추천 못하게 함
        return selectedMenu;
    }

    private static String pickMenu(String category) {
        List<String> targetMenu = MenuRepository.findMenuListByCategory(category);
        return Randoms.shuffle(targetMenu).get(0);
    }

    public static void addBannedMenu(String coach, String menu) {
        if (!containsMenu(coach, menu)) {
            bannedMenuByCoach.get(coach).add(menu);
        }
    }

    /**
     * 해당 코치가 해당 음식 제공이 금지되어 있는지 여부 반환
     */
    private static boolean isBannedMenu(String coach, String menu) {
        if (containsMenu(coach, menu)) {
            return true;
        }
        return false;
    }

    /**
     * coach에 대한 menu가 있는지 확인하며 coach에 대한 리스트가 없을 경우 초기화도 진행한다.
     */
    private static boolean containsMenu(String coach, String menu) {
        if (!bannedMenuByCoach.containsKey(coach)) {
            bannedMenuByCoach.put(coach, new HashSet<>());
        }
        return bannedMenuByCoach.get(coach).contains(menu);
    }

    /**
     * 현재 존재하는 메뉴명인지 여부를 반환한다.
     */
    public static boolean isValidMenu(String menu) {
        return MenuRepository.containsMenu(menu);
    }
}
