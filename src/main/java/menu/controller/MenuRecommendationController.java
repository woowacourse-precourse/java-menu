package menu.controller;

import static menu.configure.MenuConfigure.configure;
import static menu.repository.CoachCannotEatRepository.addCoachCannotEat;
import static menu.repository.CoachRepository.addAllCoaches;
import static menu.repository.CoachRepository.coaches;
import static menu.repository.RecommendationResultRepository.result;

import menu.service.MenuRecommendationService;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuRecommendationController {

  InputView inputView = new InputView();
  OutputView outputView = new OutputView();
  MenuRecommendationService menuRecommendationService = new MenuRecommendationService();

  public MenuRecommendationController() {
    configure();
  }

  public void run() {
    System.out.println("점심 메뉴 추천을 시작합니다.\n");
    saveCoaches();
    saveCoachCannotEat();
    for (int i = 0; i < 5; i++) {
      menuRecommendationService.recommend();
    }
    outputView.printResult();
  }

  public void saveCoaches() {
    addAllCoaches(inputView.readCoaches());
  }

  public void saveCoachCannotEat() {
    coaches().forEach(coach -> {
      addCoachCannotEat(coach, inputView.readCannotEatMenus(coach.getName()));
    });
  }
}
