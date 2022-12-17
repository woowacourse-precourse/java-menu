package menu.model;

import java.util.List;

public class Recommend {

    private static final int DAYS_SIZE=5;
    private final RandomGenerator randomGenerator;

    private Coach coach;
    private Status categoryStatus;
    private Status menuStatus;

    public Recommend(Coach coach) {
        randomGenerator = new RandomGenerator();
        this.coach = coach;
        categoryStatus = Status.NOT_OK;
        menuStatus = Status.NOT_OK;
    }

    public Category recommendCategory() {
        Category pickedCategory = null;
        while (categoryStatus == Status.NOT_OK) {

            pickedCategory = Category.from(randomGenerator.pickRandomCategory());

            if (coach.isFineCategory(pickedCategory)) {
                categoryStatus = Status.OK;
            }
            coach.countCategory(pickedCategory);
        }
        return pickedCategory;
    }

    public String recommendMenu(Category category) {
        List<String> menus = Category.getMenus(category);
        String menu = null;
        for (int i = 0; i < DAYS_SIZE; i++) {
            menuStatus=Status.NOT_OK;
            menu = getMenu(menus, menu);
        }
//        System.out.println(menu);
        return menu;
    }

    private String getMenu(List<String> menus, String menu) {
        while (menuStatus == Status.NOT_OK) {
            menu = randomGenerator.pickRandomMenu(menus);
            if(coach.isFineEatMenu(Menu.from(menu))){
                coach.addRecommendMenu(Menu.from(menu));
                menuStatus = Status.OK;
            }
        }
        return menu;
    }


}
