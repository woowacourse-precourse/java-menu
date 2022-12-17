package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class Random {
    int start=0;
    int end=9;
    public String RandomCategory(List<Menu> menu){
        String menuCategory = menu.get(Randoms.pickNumberInRange(1,5)-1).category;
        return menuCategory;
    }

    public String RandomMenu(List<Menu> menu,String Category,List<String> nonfood){
        int index = checkIndex(Category);
        String menuFood;

        while(true) {
            menuFood = Randoms.shuffle(menu.get(index-1).food).get(0);
//            Collections.shuffle(menu.get(index-1).food); 이렇게는 정상작동 . .
//            menuFood =menu.get(index-1).food.get(0);
            if (nonfood.contains(menuFood)) {
                continue;
            }
            start+=9;
            end+=9;
            break;
        }
        return menuFood;
    }

    public int checkIndex(String Category){
        int index=0;
        if(Category.equals("일식"))
            index=1;
        else if(Category.equals("한식"))
            index=2;
        else if(Category.equals("중식"))
            index=3;
        else if(Category.equals("아시안"))
            index=4;
        else if(Category.equals("양식"))
            index=5;
        return index;
    }
}
