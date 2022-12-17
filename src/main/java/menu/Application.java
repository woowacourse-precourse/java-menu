package menu;

public class Application {
    public static void main(String[] args) {
        Category category = new Category();
        for (String item : category.choose()) {
            System.out.print(item + " ");
        }
        System.out.println();

        Coach coach = new Coach();
        while (true) {
            try {
                for (String name : coach.getNames()) {
                    System.out.print(name + " ");
                }
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception);
            }
        }
        System.out.println();
    }
}
