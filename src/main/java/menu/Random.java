package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Random {
    public String RandomCategory(List<Menu> menu){
        String menuCategory = menu.get(Randoms.pickNumberInRange(1,5)).category;
        return menuCategory;
    }
    public String RandomMenu(List<Menu> menu,String Category){
        int index=0;
        for(int i=0; i<menu.size(); i++){
            if(menu.get(i).category.equals(Category)){
                index=i;
            }
        }
        String menuFood = Randoms.shuffle(menu.get(index).food).get(0);
        return menuFood;
    }
}
