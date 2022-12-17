package menu.domain;

public class RecommendMenus {

    private final String menu;
    public RecommendMenus(String menu){
        this.menu = menu;
    }

    public String getMenu(){
        return this.menu;
    }

    public boolean isRecommendable(){
        return true;
    }
}
