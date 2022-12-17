package menu.util;

import camp.nextstep.edu.missionutils.Randoms;
import menu.model.domain.Category;
import menu.model.service.CoachService;
import menu.model.service.FoodService;

import java.util.*;

public class ParingCategory {
    private static final String MONDAY = "월요일";
    private static final String TUESDAY = "화요일";
    private static final String WEDNESDAY = "수요일";
    private static final String THURSDAY = "목요일";
    private static final String FRIDAY = "금요일";

    public static Map<String, Category> initCategoryOrder(FoodService foodService, CoachService coachService) {
        Map<String, Category> categoryList = new HashMap<>();
        initDayCategory(categoryList);

        Category category = Category.getValueOf(Randoms.pickNumberInRange(1, 5));
        categoryList.put(MONDAY, category);
        category = Category.getValueOf(Randoms.pickNumberInRange(1, 5));
        categoryList.put(TUESDAY, category);

        for (int i = 3; i <= 5; i++) {
            category = Category.getValueOf(Randoms.pickNumberInRange(1, 5));
            if (i == 3) {
                List<Category> tmp = new ArrayList<>();
                tmp.add(getCategory(1, categoryList));
                tmp.add(getCategory(2, categoryList));
                HashSet<Category> hashTmp = new HashSet<>(tmp);
                System.out.println(tmp.get(0) + " " + tmp.get(1));
                if (hashTmp.size() == 2) {
                    categoryList.put(WEDNESDAY, category);
                }
                else if (hashTmp.size() == 1) {
                    while (hashTmp.contains(category)) {
                        category = Category.getValueOf(Randoms.pickNumberInRange(1, 5));
                    }
                    categoryList.put(WEDNESDAY, category);
                }
            } else if (i == 4) {
                List<Category> tmp = new ArrayList<>();
                tmp.add(getCategory(1, categoryList));
                tmp.add(getCategory(2, categoryList));
                tmp.add(getCategory(3, categoryList));
                HashSet<Category> hashTmp = new HashSet<>(tmp);
                if (hashTmp.size() == 3) {
                    categoryList.put(THURSDAY, category);
                }
                else if (hashTmp.size() == 2) {
                    Category finalCategory = category;
                    while (true) {
                        Category random = Category.getValueOf(Randoms.pickNumberInRange(1, 5));
                        if (!hashTmp.contains(category) || (hashTmp.contains(category) && tmp.stream().
                                filter(x -> x.equals(random))
                                .count() < 2)) {
                            categoryList.put(THURSDAY, category);
                            break;
                        }
                    }
                }
            } else if (i == 5) {
                List<Category> tmp = new ArrayList<>();
                tmp.add(getCategory(1, categoryList));
                tmp.add(getCategory(2, categoryList));
                tmp.add(getCategory(3, categoryList));
                tmp.add(getCategory(4, categoryList));
                for (Category category1 : tmp) {
                    System.out.println(category1.getCategory());
                }
                HashSet<Category> hashTmp = new HashSet<>(tmp);
                if (hashTmp.size() == 4) {
                    categoryList.put(FRIDAY, category);
                }
                else if (hashTmp.size() == 3) {
                    while (true) {
                        Category random = Category.getValueOf(Randoms.pickNumberInRange(1, 5));
                        if (!hashTmp.contains(category) || (hashTmp.contains(category) && tmp.stream().
                                filter(x -> x.equals(random))
                                .count() < 2)) {
                            categoryList.put(FRIDAY, category);
                            break;
                        }
                    }
                }
            }
        } return categoryList;
    }

    private static void initDayCategory(Map<String, Category> categoryList) {
        categoryList.put(MONDAY, null);
        categoryList.put(TUESDAY, null);
        categoryList.put(WEDNESDAY, null);
        categoryList.put(THURSDAY, null);
        categoryList.put(FRIDAY, null);
    }

    private static Category getCategory(int index, Map<String, Category> categoryList) {
        if (index == 1) {
            return categoryList.get(MONDAY);
        } else if (index == 2) {
            return categoryList.get(TUESDAY);
        } else if (index == 3) {
            return categoryList.get(WEDNESDAY);
        } else if (index == 4) {
            return categoryList.get(THURSDAY);
        }
        return categoryList.get(FRIDAY);
    }
}
