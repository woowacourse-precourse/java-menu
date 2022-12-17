package menu.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.ui.Input;
import menu.ui.Output;

public class RecommendController {
    private final CategoryController categoryController;
    private final CoachController coachController;
    private final Input input;
    private final Output output;
    private List<Category> weekCategory;

    public RecommendController() {
        this.categoryController = new CategoryController();
        this.coachController = new CoachController();
        this.input = new Input();
        this.output = new Output();
        this.weekCategory = new ArrayList<>();
    }

    public void run() {
        output.printStartMessage();
        String coachNamesInput = input.coachNamesInput();
        List<Coach> coaches = makeCoachs(coachNamesInput);
        setCantEatFood(coachNamesInput);
        weekCategory = categoryController.weekCategory();
        for (Coach coach : coaches) {
            coach.addRecommendFood(makeRecommendFoods(weekCategory));
        }

        output.printRecommendResult(coaches, weekCategory);
        output.printEndMessage();

    }

    public List<Coach> makeCoachs(String coachNamesInput) {
        return coachController.makeCoachs(coachNamesInput);
    }

    public void setCantEatFood(String coachNamesInput) {
        List<String> cantEatFoodInputEachCoach = input.cantEatFoodInputEachCoach(coachNamesInput);
        coachController.setCantEatFood(cantEatFoodInputEachCoach);
    }

    public List<String> makeRecommendFoods(List<Category> categories) {
        List<String> result = new ArrayList<>();
        for (Category category : categories) {
            result.add(selectRecommendFood(category));
        }
        return result;
    }

    public String selectRecommendFood(Category category) {
        String result = "";
        while (true) {
            result = Randoms.shuffle(category.getMenu()).get(0);
            if (coachController.getCantEatFoods().contains(result)) {
                continue;
            }
            break;
        }

        return result;
    }
}
