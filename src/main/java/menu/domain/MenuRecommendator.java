package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MenuRecommendator {
    private static final int START_MENU_NUMBER= 1;
    private static final int END_MENU_NUMBER = 5;
    private static final long ALLOWED_DUPLICATED_CATEGORY_NUMBER = 2L;

    private List<Category> categories = new ArrayList<>();

    public MenuRecommendator(){
        initCategories();
    }

    private void initCategories(){
        while(categories.size()<END_MENU_NUMBER){
            Category selected = Category.fromInput(Randoms.pickNumberInRange(START_MENU_NUMBER,END_MENU_NUMBER));
            if(isOverDuplicatedCategory(selected)){
                continue;
            }
            categories.add(selected);
        }
    }

    private boolean isOverDuplicatedCategory(Category newCategory){
        return categories.stream().filter(category->category.equals(newCategory))
                .count()>=ALLOWED_DUPLICATED_CATEGORY_NUMBER;
    }

    public void recommendMenu(Coaches coaches){
        //카테고리 5개별로
        // 코치마다 메뉴를 셔플 후 첫번째 메뉴를 추가
        // 코치가 중복되는 메뉴를 이미 선택했을 시 셔플 후 재선택
        for(Category category : categories){
            for(Coach coach : coaches.getCoaches()){
                selectMenu(coach, category);
            }
        }
    }

    private void selectMenu(Coach coach, Category category){
        while(true){
            String menu = Randoms.shuffle(Menu.fromInput(category).getMenus()).get(0);
            if(coach.addSelectedMenu(menu)){
                break;
            }
        }
    }

    public List<String> getCategories(){
        return categories.stream()
                .map(Category::getCategoryName)
                .collect(Collectors.toList());
    }

}
