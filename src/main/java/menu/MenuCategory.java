package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class MenuCategory {
    private static final Integer JAPANESE_MENU_CATEGORY_NUMBER = 1;
    private static final Integer KOREAN_MENU_CATEGORY_NUMBER = 2;
    private static final Integer CHINESE_MENU_CATEGORY_NUMBER = 3;
    private static final Integer ASIAN_MENU_CATEGORY_NUMBER = 4;
    private static final Integer WESTERN_MENU_CATEGORY_NUMBER = 5;


    private static final int MENU_MIN_SIZE = 1;
    private static final int MENU_MAX_SIZE = 5;
    private HashMap<Integer, String> categoryNumberAndCategory;

    public MenuCategory() {
        HashMap<Integer, String> categoryNumberAndCategory = new HashMap<>();
        categoryNumberAndCategory.put(JAPANESE_MENU_CATEGORY_NUMBER, "일식");
        categoryNumberAndCategory.put(KOREAN_MENU_CATEGORY_NUMBER, "한식");
        categoryNumberAndCategory.put(CHINESE_MENU_CATEGORY_NUMBER, "중식");
        categoryNumberAndCategory.put(ASIAN_MENU_CATEGORY_NUMBER, "아시안");
        categoryNumberAndCategory.put(WESTERN_MENU_CATEGORY_NUMBER, "양식");
        this.categoryNumberAndCategory = categoryNumberAndCategory;
    }


    public Queue<String> createMenuForEachDay() {
        HashMap<Integer, Integer> categoryNumberAndCount = initCategoryNumberAndCount();
        Queue<String> queue = new LinkedList<>();
        int dayCount = 0;
        while(dayCount < 5){
            int categoryNumber = Randoms.pickNumberInRange(MENU_MIN_SIZE, MENU_MAX_SIZE);
            if(categoryNumberAndCount.get(categoryNumber) < 2){
                categoryNumberAndCount.put(categoryNumber, categoryNumberAndCount.get(categoryNumber) + 1);
                queue.add(categoryNumberAndCategory.get(categoryNumber));
                dayCount++;
            }
        }
        return queue;
    }

    private HashMap<Integer, Integer> initCategoryNumberAndCount() {
        HashMap<Integer, Integer> categoryNumberAndCount = new HashMap<>();
        categoryNumberAndCount.put(JAPANESE_MENU_CATEGORY_NUMBER, 0);
        categoryNumberAndCount.put(KOREAN_MENU_CATEGORY_NUMBER, 0);
        categoryNumberAndCount.put(CHINESE_MENU_CATEGORY_NUMBER, 0);
        categoryNumberAndCount.put(ASIAN_MENU_CATEGORY_NUMBER, 0);
        categoryNumberAndCount.put(WESTERN_MENU_CATEGORY_NUMBER, 0);
        return categoryNumberAndCount;
    }
}
