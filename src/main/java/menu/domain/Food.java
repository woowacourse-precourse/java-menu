package menu.domain;

public class Food {
    private String category;
    private String name;

    public Food(String category, String name){
        this.category = category;
        this.name = name;
    }

    public String getName(){return this.name;}
    public String getCategory(){return this.category;}
}
