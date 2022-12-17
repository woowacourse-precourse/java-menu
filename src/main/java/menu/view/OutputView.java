package menu.view;

import menu.GuideMessage;

public class OutputView {

  public void printStart() {
    System.out.println(GuideMessage.START.getMessage());
    System.out.println();
  }

  public void printInputCoachName() {
    System.out.println(GuideMessage.INPUT_COACH.getMessage());
  }

  public void printInputFoodCantEat(String coach) {
    System.out.println();
    System.out.println(GuideMessage.INPUT_FOOD_CANT_EAT.print(coach));
  }

  public void printRecommendationResult() {
    System.out.println();
    System.out.println(GuideMessage.OUTPUT_RECOMMENDATION_RESULT.getMessage());
  }

  public void printEnd() {
    System.out.println();
    System.out.println(GuideMessage.OUTPUT_COMPLETE_RECOMMENDATION.getMessage());
  }
}
