package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        HashMap<String, HashSet<String>> coachesMealPlan = new HashMap<>();
        HashMap<String, String> categoryNameOfWeek = new HashMap<>();
        List<String> week = Arrays.asList("월요일", "화요일", "수요일", "목요일", "금요일");
        HashMap<String, Set<String>> coachesHateFood = new HashMap<>();

        while (true) {
            System.out.println("점심 메뉴 추천을 시작합니다.");
            List<String> coaches = InputView.inputNames();

            for (String name : coaches) {
                System.out.println(name + "(이)가 못 먹는 메뉴를 입력해 주세요.");
                coachesHateFood.put(name, new HashSet<>(InputView.inputHateFoods()));
                System.out.println(coachesHateFood.get(name));
                System.out.println(coachesHateFood.get(name).size());
            }

            while (true) {
                Map<String, Integer> pickedCategoryCount = new HashMap<>();
                for (int i = 0; i < 5; i++) {
                    String randomCategory = Category.getCategoryByNumber(Randoms.pickNumberInRange(1, 5)).getName();
                    pickedCategoryCount.put(randomCategory, pickedCategoryCount.getOrDefault(randomCategory, 0) + 1);
                    categoryNameOfWeek.put(week.get(i), randomCategory);
                }

                for (Map.Entry<String, Integer> entry : pickedCategoryCount.entrySet()) {
                    if (entry.getValue() > 2) {
                        pickedCategoryCount.clear();
                        categoryNameOfWeek.clear();
                        continue;
                    }
                }
                break;
            }

            System.out.println("메뉴 추천 결과입니다.");
            System.out.print(categoryNameOfWeek.keySet() + " ");
            System.out.print(categoryNameOfWeek.values());

            for (int i = 0; i < coachesHateFood.size(); ) {
                for (Map.Entry<String, Set<String>> entry : coachesHateFood.entrySet()) {
                    System.out.println("오류원인 : " + categoryNameOfWeek.get(week.get(i)));
                    String categoryName = categoryNameOfWeek.get(week.get(i));
                    List<String> menus = Category.getMenusByCategoryName(categoryName);
                    String menu = Randoms.shuffle(menus).get(0);

                    if (!entry.getValue().contains(menu)) {
                        int mealPlanSize = coachesMealPlan.get(entry.getKey()).size();
                        coachesMealPlan.get(entry.getKey()).add(menu);
                        if (coachesMealPlan.get(entry.getKey()).size() != mealPlanSize) {
                            i++;
                        }
                    }
                }
            }

            System.out.println(coachesMealPlan);
        }
    }
}
