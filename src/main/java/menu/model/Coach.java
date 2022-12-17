package menu.model;

public class Coach {
    private String name;
    private String[] banFoods;
    private MenusOfWeek menusOfWeek;

    public Coach(String name){
        this.name = name;
        menusOfWeek = new MenusOfWeek();
    }

    public void setBanFoods(String[] banFoods){
        this.banFoods = banFoods;
    }
    public MenusOfWeek getMenusOfWeek(){
        return menusOfWeek;
    }

    public String getName(){
        return name;
    }
    public void addMenu(Menu menu){
        menusOfWeek.add(menu);
    }
}
