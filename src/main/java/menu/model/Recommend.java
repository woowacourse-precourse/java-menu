package menu.model;

import java.util.List;

public class Recommend {

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

            if (categoryStatus == Status.OK) {
                break;
            }
        }
        return pickedCategory;
    }

    public String recommendMenu(Category category) {
        List<String> menus = Category.getMenus(category);
        String menu = null;
        while (menuStatus == Status.NOT_OK) {
            menu = randomGenerator.pickRandomMenu(menus);
            if(coach.isFineEatMenu(menu)){
                menuStatus = Status.OK;
            }
            if(menuStatus==Status.OK){
                break;
            }
        }
        return menu;
    }


}
