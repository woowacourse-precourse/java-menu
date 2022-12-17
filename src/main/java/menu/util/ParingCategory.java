package menu.util;

import camp.nextstep.edu.missionutils.Randoms;
import menu.model.domain.Category;
import menu.model.domain.Coach;
import menu.model.service.CoachService;
import menu.model.service.FoodService;

import java.util.*;

public class ParingCategory {
    private static final String MONDAY = "월요일";
    private static final String TUESDAY = "화요일";
    private static final String WEDNESDAY = "수요일";
    private static final String THURSDAY = "목요일";
    private static final String FRIDAY = "금요일";

    public static List<Category> initCategoryOrder() {
        List<Category> categoryList = new ArrayList<>(5);

        Category category = Category.getValueOf(Randoms.pickNumberInRange(1, 5));
        categoryList.add(category);
        category = Category.getValueOf(Randoms.pickNumberInRange(1, 5));
        categoryList.add(category);
        for (int i = 3; i <= 5; i++) {
            category = Category.getValueOf(Randoms.pickNumberInRange(1, 5));
            if (i == 3) {
                List<Category> tmp = new ArrayList<>();
                tmp.add(Category.getValueOf(1));
                tmp.add(Category.getValueOf(2));
                HashSet<Category> hashTmp = new HashSet<>(tmp);
//                System.out.println(tmp.get(0) + " " + tmp.get(1));
                if (hashTmp.size() == 2) {
                    categoryList.add(category);
                } else if (hashTmp.size() == 1) {
                    while (hashTmp.contains(category)) {
                        category = Category.getValueOf(Randoms.pickNumberInRange(1, 5));
                    }
                    categoryList.add(category);
                }
            } else if (i == 4) {
                List<Category> tmp = new ArrayList<>();
                tmp.add(Category.getValueOf(1));
                tmp.add(Category.getValueOf(2));
                tmp.add(Category.getValueOf(3));
                HashSet<Category> hashTmp = new HashSet<>(tmp);
                if (hashTmp.size() == 3) {
                    categoryList.add(category);
                } else if (hashTmp.size() == 2) {
                    while (true) {
                        Category random = Category.getValueOf(Randoms.pickNumberInRange(1, 5));
                        if (!hashTmp.contains(random) || (hashTmp.contains(category) && tmp.stream().
                                filter(x -> x == random)
                                .count() < 2)) {
                            categoryList.add(random);
                            break;
                        }
                    }
                }
            } else if (i == 5) {
                List<Category> tmp = new ArrayList<>();
                tmp.add(Category.getValueOf(1));
                tmp.add(Category.getValueOf(2));
                tmp.add(Category.getValueOf(3));
                tmp.add(Category.getValueOf(4));
                HashSet<Category> hashTmp = new HashSet<>(tmp);
                if (hashTmp.size() == 4) {
                    categoryList.add(category);
                } else if (hashTmp.size() == 3) {
                    while (true) {
                        Category random = Category.getValueOf(Randoms.pickNumberInRange(1, 5));
                        if (!hashTmp.contains(random) || (hashTmp.contains(random) && tmp.stream().
                                filter(x -> x.equals(random))
                                .count() < 2)) {
                            categoryList.add(random);
                            break;
                        }
                    }
                } else if (hashTmp.size() == 2) {
                    while (true) {
                        Category random = Category.getValueOf(Randoms.pickNumberInRange(1, 5));
                        if (!hashTmp.contains(random) || (hashTmp.contains(random) && tmp.stream().
                                filter(x -> x.equals(random))
                                .count() < 2)) {
                            categoryList.add(random);
                            break;
                        }
                    }
                }
            }
        }
        return categoryList;
    }

    public static void initFoodOrderForCoach(FoodService foodService, CoachService coachService,
                                             List<Category> categoryMap) {
        List<Category> days = Arrays.asList(Category.getValueOf(1), Category.getValueOf(2),
                Category.getValueOf(3), Category.getValueOf(4), Category.getValueOf(5));

        List<String> allNames = coachService.findAllNames();
        for (String name : allNames) {
            for (Category day : days) {
                Category category = categoryMap.stream().filter(x -> x.equals(day))
                        .findFirst().orElse(null);
                Coach coach = coachService.findByName(name);
                List<String> foodList = foodService.findAllNamesByCategory(category);
                List<String> cannotEatFoods = coach.getCannotEatFoods();

                String menu;

                menu = Randoms.shuffle(foodList).get(0);
                if (cannotEatFoods.contains(menu)) {
                    while (true) {
                        menu = Randoms.shuffle(foodList).get(0);
                        if (cannotEatFoods.contains(menu)) {
                            break;
                        }
                    }
                }
                if(coach.getLunchMenu().isEmpty()) {
                    coach.setLunchMenu(menu);
                } else if (coach.getLunchMenu().contains(menu)) {
                    while (true) {
                        menu = Randoms.shuffle(foodList).get(0);
                        if (!coach.getLunchMenu().contains(menu)) {
                            coach.setLunchMenu(menu);
                            break;
                        }
                    }
                } else {
                    coach.setLunchMenu(menu);
                }
            }

//            Coach byName = coachService.findByName(name);
//            System.out.println(byName.getLunchMenu());
        }
    }

    private static Category getCategory ( int index, List<String> categoryList){
        if (index == 1) {
            return Category.getValueOf(1);
        } else if (index == 2) {
            return Category.getValueOf(2);
        } else if (index == 3) {
            return Category.getValueOf(3);
        } else if (index == 4) {
            return Category.getValueOf(4);
        }
        return Category.getValueOf(5);
    }
}
