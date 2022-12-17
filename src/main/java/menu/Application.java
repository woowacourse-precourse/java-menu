package menu;

public class Application {
    public static void main(String[] args) {
        Category category = new Category();

        for (String item : category.choose()) {
            System.out.print(item + " ");
        }
    }
}
