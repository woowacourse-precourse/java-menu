package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Random {
    public String RandomCategory(List<Menu> menu){
        String menuCategory = menu.get(Randoms.pickNumberInRange(1,5)-1).category;
        return menuCategory;
    }
    public String RandomMenu(List<Menu> menu,String Category,List<String> nonfood){

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
//        System.out.println(Category);
//        for(int i=0; i<menu.get(index-1).food.size(); i++){
//            System.out.print(Randoms.shuffle(menu.get(index-1).food).get(i));
//        }
//        System.out.println("");

        String menuFood;

        while(true) {
            menuFood = Randoms.shuffle(menu.get(index-1).food).get(0);
            if(!menu.contains(menuFood)){
                continue;
            }
            if (nonfood.contains(menuFood)) {
                continue;
            }
            break;
        }
        return menuFood;
    }
}
