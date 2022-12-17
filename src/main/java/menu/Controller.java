package menu;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<String> coachName;
    private List<Coach> coach;
    private OutputView outputView;

    private static final Category[] categories = Category.values();

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
                    recommendMenu(coach, recommendCategory);
                    break;
                }
            }
        }
        printResult(dailyCategory, coach);
    }

    private void recommendMenu(List<Coach> coach, int num){
        for (Coach eachCoach : coach) {
            while (true) {
                Menu menu = new Menu(categories[num - 1].getMenuList());
                if (eachCoach.isValidMenu(menu)) {
                    break;
                }
            }
        }
    }

    private void printResult(List<Integer> dailyCategory, List<Coach> coach){
        outputView.printResultTitle();
        outputView.printCategory(categories, dailyCategory);
        for (Coach eachCoach : coach) {
            outputView.printRecommendedFood(eachCoach);
        }
    }
}
