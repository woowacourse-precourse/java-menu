package menu.model;

public class Coach {
    private String name;
    private String[] banFoods;
    private MenusOfWeek menusOfWeek;

    public Coach(String name, String[] banFoods){
        this.name = name;
        this.banFoods = banFoods;
        menusOfWeek = new MenusOfWeek();
    }

    public MenusOfWeek getMenusOfWeek(){
        return menusOfWeek;
    }
    public void addMenu(Menu menu){
        menusOfWeek.add(menu);
    }
}
