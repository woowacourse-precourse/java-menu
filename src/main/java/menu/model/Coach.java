package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private String name;
    private String[] banFoods;
    //private MenusOfWeek menusOfWeek;
    List<Menu> menusOfWeek;

    public Coach(String name){
        this.name = name;
        menusOfWeek = new ArrayList<>();
    }

    public void setBanFoods(String[] banFoods){
        this.banFoods = banFoods;
    }
    public List<Menu> getMenusOfWeek(){
        return menusOfWeek;
    }

    public String getName(){
        return name;
    }

    public String[] getBanFoods(){
        return banFoods;
    }
    public void addMenu(Menu menu){
        menusOfWeek.add(menu);
    }
}
