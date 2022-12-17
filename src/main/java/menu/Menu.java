package menu;

public class Menu {

    private String name;
    private String category;

    public Menu(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public boolean isSame(String menuName) {
        return this.name.equals((menuName));
    }


}
