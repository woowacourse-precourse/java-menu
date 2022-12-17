package menu.category;

import camp.nextstep.edu.missionutils.Randoms;
import menu.coach.Coach;
import org.assertj.core.util.Sets;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CategoryService {

    // 주별 카테고리 추천 목록 (각 카테고리의 번호로 저장, 순서: 월/화/수/목/금)
    private static List<Integer> recommendCategoryNumbers = new ArrayList<>();

    public static List<Integer> getRecommendCategoryNumbers() {
        return recommendCategoryNumbers;
    }

    /**
     * TODO: 카테고리 랜덤 추천
     * 한 주에 같은 카테고리는 최대 2개
     * 추천된 카테고리 숫자들의 종류 개수가 3 이하라면 한 카테고리가 3회 이상 중복된 것
     */
    public static void recommendCategories() {
        List<Integer> recommendCategoryNumbers = new ArrayList<>();
        while (true) {
            for (int i = 0; i < 5; i++) recommendCategoryNumbers.add(Randoms.pickNumberInRange(1, 5));
            Set<Integer> recommendNumbers = Sets.newHashSet(recommendCategoryNumbers);
            if (recommendNumbers.size() > 3) break;
            recommendCategoryNumbers = new ArrayList<>(); // break 하지 않을 경우 초기화
        }
        CategoryService.recommendCategoryNumbers = recommendCategoryNumbers;
    }

    /**
     * TODO: 코치별 메뉴 랜덤 추천
     * 중복되지 않도록, 못 먹는 메뉴는 제외
     *
     * @param coach
     * @return 코치에게 추천된 메뉴 List
     */
    public static List<String> setRecommendMenusToCoach(Coach coach) {
        List<String> recommendMenus = new ArrayList<>();
        for (Integer recommendCategoryNumber : recommendCategoryNumbers) {
            List<String> menusOfCategory = Category.getCategoryMenusByNumber(recommendCategoryNumber);
            String randomMenu;
            while (true) {
                randomMenu = Randoms.shuffle(menusOfCategory).get(0); // ApplicationTest에서 menusOfCategory에 없는 메뉴를 반환합니다.. (직접 실행시에는 정상 반환)
                // System.out.println(String.valueOf(recommendCategoryNumber) + menusOfCategory); System.out.println(randomMenu);
                if (!isCannotEats(coach, randomMenu) && !isDuplicateRecommendMenu(recommendMenus, randomMenu))
                    break;
            }
            recommendMenus.add(randomMenu);
        }
        return recommendMenus;
    }

    /**
     * 코치가 못 먹는 메뉴인지 확인
     *
     * @param coach
     * @param randomMenu 확인할 메뉴
     * @return 해당 코치가 못 먹는 메뉴라면 true, 아니라면 false
     */
    private static boolean isCannotEats(Coach coach, String randomMenu) {
        List<String> cannotEats = coach.getMenusCannotEats();
        for (String cannotEat : cannotEats) {
            if (cannotEat.compareTo(randomMenu) == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 추천 메뉴 중복 확인
     *
     * @param recommendMenus 그동안 추천된 메뉴 목록
     * @param randomMenu     확인할 메뉴
     * @return 중복된 메뉴라면 true, 아니라면 false
     */
    private static boolean isDuplicateRecommendMenu(List<String> recommendMenus, String randomMenu) {
        for (String recommendMenu : recommendMenus) {
            if (recommendMenu.compareTo(randomMenu) == 0) return true;
        }
        return false;
    }

}
