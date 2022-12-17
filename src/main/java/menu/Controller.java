package menu;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<String> coachName;
    private List<Coach> coach;
    private OutputView outputView;

    public final Category[] categories = Category.values();

    public Controller(List<String> coachName, List<Coach> coach){
        this.coachName = coachName;
        this.coach = coach;
        this.outputView = new OutputView();
    }
    public void start() {
        List<Integer> dailyCategory = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            while (true) {
                int recommendCategory = RandomNumGenerator.makeCategoryNum();
                if (dailyCategory.stream().filter(num -> num == recommendCategory).count() < 2) {
                    dailyCategory.add(recommendCategory);
                    break;
                }
            }
            for (Coach eachCoach : coach) {
                while (true) {
                    Menu menu = new Menu(categories[dailyCategory.get(i) - 1].getMenuList());
                    if (eachCoach.isValidMenu(menu)) {
                        break;
                    }
                }
            }
        }
        outputView.printResultTitle();
        outputView.printCategory(categories, dailyCategory);
        for (Coach eachCoach : coach) {
            outputView.printRecommendedFood(eachCoach);
        }
    }
}
