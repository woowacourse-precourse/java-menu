package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.repository.MenuRepository;
import menu.repository.WeekendRepository;

public class MenuRecommendService {

    //TODO : Map<Weekend,List<Menu> 생성?
    // 코치끼리 비교할 필요 x 
    // 각 코치마다 생성된 메뉴들을 못먹는 음식과 비교
    // 같은 카테고리는 한주에 2회까지만 가능 check
    // 코치에게 중복되지않는 메뉴를 추천해줘야함
    // 매 요일마다 카테고리를 생성한다
    // 요일마다 카테고리를 지정해준다
    // 만약 같은카테고리가 3개 초과한다면 다시 선택.
    public static Map<String, List<Menu>> MakeNewRecommendMenu(List<Coach> coaches) {
        List<Weekend> weekends = WeekendRepository.weekends();
        Map<String, List<Menu>> recommendedMenuList = new HashMap<>();
        for (Weekend day : weekends) {
            Category dayOfTheCategory = Category.findByCommand(Randoms.pickNumberInRange(1, 5));
            day.createCategory(dayOfTheCategory);
        }
        if (!WeekendRepository.checkDuplication(weekends)) {
            MakeNewRecommendMenu(coaches);
        }
        makeListOfMenu(weekends, coaches, recommendedMenuList);

        return recommendedMenuList;
    }

    private static void makeListOfMenu(List<Weekend> weekend, List<Coach> coaches,
        Map<String, List<Menu>> recommendedMenuList) {
        for (Weekend day : weekend) {
            List<Menu> menu = MenuRepository.findMenuByCategory(day.getCategory());
            List<String> menuNames = MenuRepository.getMenuName(menu);
            for (Coach coach : coaches) {
            List<Menu> recommendMenu = new ArrayList<>();
                List<Menu> canNotEatMenus = coach.getCanNotEatMenu();
                while (recommendMenu.size() < 5) {
                    String menuName = Randoms.shuffle(menuNames).get(0);
                    if (!canNotEatMenus.contains(menuName)) {
                        recommendMenu.add(MenuRepository.findByMenuName(menuName));
                    }

                }
            }
        }
    }

}
