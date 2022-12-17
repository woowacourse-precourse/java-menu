package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static menu.Menu.staticMenu;

public class LunchMenuService {

    private List<List<String>>menus = staticMenu;
    private final CategoryMaker categoryMaker;
    private final Category category;

    public LunchMenuService(){
        this.categoryMaker = new CategoryMaker(new CategoryRandomGenerator());
        this.category = new Category(categoryMaker.makeCategories());
    }

    public String randomRecommendMenu(int index){
        int food = category.getPositions().get(index);
        System.out.println(food);
        return Randoms.shuffle(menus.get(food-1)).get(0);
    }

    public boolean checkDuplicate(List<String> recommendedMenus,String recommendMenu){
        for(String recommendedMenu : recommendedMenus){
            if(recommendedMenu.equals(recommendMenu)){
                return false;
            }
        }
        return true;
    }
}
