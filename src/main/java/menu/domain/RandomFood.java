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
        for(String category: categories){
            List<String> menus = foods.get(findCategory(category));
            String menu = Randoms.shuffle(menus).get(0);
            if(!notFoods.get(coachNames).contains(menu)){
                pickMenus.add(menu);
            }

            randomFoods.put(coachNames,pickMenus);
        }
        return randomFoods;
    }
    
}
