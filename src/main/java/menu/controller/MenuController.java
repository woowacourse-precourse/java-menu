package menu.controller;

import menu.model.Coach;
import menu.service.CoachService;
import menu.service.RecommendationService;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class MenuController {

  InputView inputView = new InputView();
  OutputView outputView = new OutputView();
  CoachService coachService = new CoachService();
  RecommendationService recommendationService = new RecommendationService();

  public void run() {
    outputView.printStart();
    outputView.printInputCoachName();
    String coachesName = inputView.readCoachesName();
    String[] coaches = coachesName.split(",");
    List<Coach> generatedCoach = coachService.makeCoaches(coachesName);
    for (int i = 0; i < coaches.length; i++) {
      outputView.printInputFoodCantEat(coaches[i]);
      String hateFood = inputView.readFoodCantEat();
      String[] hateFoods = hateFood.split(",");
      for (int j = 0; j < hateFoods.length; j++) {
        coachService.insertHateFood(coaches[i], hateFoods[j]);
      }
    }
    outputView.printRecommendationResult();

    System.out.println(recommendationService.getRecommendationResult(generatedCoach));

    outputView.printEnd();

  }
}
