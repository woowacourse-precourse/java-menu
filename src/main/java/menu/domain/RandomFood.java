package menu.domain;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class RandomFood {
    private List<String> randomCategories = new ArrayList<>();
    private List<String> categories = new ArrayList<>(Arrays.asList(" ", "일식", "한식", "중식", "아시안", "양식"));
    private Map<String, List<String>> randomFoods = new HashMap<>();

    public String pickCategory() {
        String category = categories.get(Randoms.pickNumberInRange(1, 5));
        return category;
    }

    public List<String> allCategory() {
        String category;
        int count = 0;
        while (count < 5) {
            category = pickCategory();
            if (Collections.frequency(randomCategories, category) < 2) {
                randomCategories.add(category);
                count++;
            }
        }
        return randomCategories;
    }

    public Category findCategory(String category){
        List<Category> categoriesNames = List.of(Category.values());
        for(Category categoryName:categoriesNames){
            if(categoryName.getFoodType().equals(category)){
                return categoryName;
            }
        }
        return null;
    }


    public Map<String,List<String>> pickFoods(String coachNames, Map<Category, List<String>> foods, List<String> categories, Map<String,List<String>> notFoods) {
        List<String> pickMenus = new ArrayList<>();
        List<String> menus = new ArrayList<>();
        for(String category: categories){
            menus = foods.get(findCategory(category));
            String menu = Randoms.shuffle(menus).get(0);
            if(!notFoods.get(coachNames).contains(menu)){
                pickMenus.add(menu);
            }
//            for (String notFood : notFoods.get(coachNames)) {
////                String menu = Randoms.shuffle(menus).get(0);
//                pickMenus = makeRandomFood(notFood, menu);
//            }
            randomFoods.put(coachNames,pickMenus);
            System.out.println(randomFoods.get(coachNames).toString());
        }
        return randomFoods;
    }

    public List<String> makeRandomFood(String notFood, String menu) {
        List<String> pickMenus = new ArrayList<>();
        int count = 0;
        while(count<5){
            if (Collections.frequency(pickMenus, menu) < 2 && !menu.equals(notFood)) {
                count++;
                pickMenus.add(menu);
                System.out.println("PICK"+pickMenus.toString());
            }
        }
        return pickMenus;
    }
}
