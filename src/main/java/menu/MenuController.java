package menu;

import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class MenuController {
    FoodRecommendation foodRecommendation;
    public void run() {
        OutputView.start();
        foodRecommendation = new FoodRecommendation();
        List<Coach> coaches = readCoachName();

        for(Coach coach : coaches) {
            OutputView.inputInedibleFood(coach);
            coach.addFoods(InputView.readInedibleFoods());

            foodRecommendation.recommend(coach);
        }

        OutputView.result(foodRecommendation.getRecommend());
    }

    private List<Coach> readCoachName() {
        OutputView.inputCoachName();
        return InputView.readCoachName().stream()
                .map(Coach::new)
                .collect(Collectors.toList());
    }


}
