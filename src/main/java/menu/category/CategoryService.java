package menu.category;

import camp.nextstep.edu.missionutils.Randoms;
import menu.coach.Coach;
import menu.coach.CoachService;
import menu.view.OutputView;
import org.assertj.core.util.Sets;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CategoryService {

    // 못 먹는 메뉴 기반 랜덤 추천
    public static void recommendMenu() {
        List<Coach> coaches = CoachService.getCoaches();
        for (Coach coach : coaches) {
            List<String> recommendCategoriesToCoach = setRecommendCategoriesToCoach(coach);
            List<String> recommendMenusToCoach = setRecommendMenusToCoach(coach, recommendCategoriesToCoach);
            coach.setRecommendedMenu(recommendCategoriesToCoach);
        }
        OutputView.printRecommendResult(coaches);
    }

    // 코치별 카테고리 랜덤 추천
    private static List<String> setRecommendCategoriesToCoach(Coach coach) {
        // 카테고리 추천 (한 주에 같은 카테고리는 최대 2회)
        List<Integer> recommendCategories_number = new ArrayList<>();
        while (true) {
            for (int i = 0; i < 5; i++) {
                recommendCategories_number.add(Randoms.pickNumberInRange(1, 5));
            }
            Set<Integer> recommendCategoryNumbers = Sets.newHashSet(recommendCategories_number);
            if (recommendCategoryNumbers.size() > 3) break; // 추천 카테고리 숫자들에 대한 set 개수가 3 이하 -> 3회 이상 중복된 것
            recommendCategories_number = new ArrayList<>(); // break 하지 않을 경우 초기화
        }

        // 숫자 -> 이름으로 변환
        List<String> recommendCategories_name = new ArrayList<>();
        for (int recommendCategoryNumber : recommendCategories_number) {
            recommendCategories_name.add(Category.getCategoryNameByNumber(recommendCategoryNumber));
        }
        return recommendCategories_name;
    }

    // 코치별 메뉴 랜덤 추천
    private static List<String> setRecommendMenusToCoach(Coach coach, List<String> recommendCategoriesToCoach) {
        List<String> recommendMenus = new ArrayList<>();
        return recommendMenus;
    }

}
