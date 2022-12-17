package menu.service;

import static menu.repository.CategoryRepository.findAllCategoryNames;
import static menu.repository.CoachRepository.coaches;
import static menu.repository.MenuRepository.findMenusByCategory;
import static menu.repository.RecommendationResultRepository.addMenu;
import static menu.repository.RecommendationResultRepository.existMenu;
import static menu.repository.RecommendationResultRepository.isValidCategory;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Menu;

public class MenuRecommendationService {

  private static final int DAYS = 5;

  public void recommend() {
    Category category = recommendCategory();
    coaches().forEach(coach -> {
      addMenu(coach, recommendMenu(coach, category));
    });
  }

  private Category recommendCategory() {
    while (true) {
      Category category = getRandomCategory();
      if (isValidCategory(category)) {
        return category;
      }
    }
  }

  private Category getRandomCategory() {
    return new Category(findAllCategoryNames().get(Randoms.pickNumberInRange(1, 5)));
  }

  private Menu recommendMenu(Coach coach, Category category) {
    Menu menu;
    do {
      menu = getRandomMenu(category);
    } while (!existMenu(coach, menu));
    return menu;
  }

  private Menu getRandomMenu(Category category) {
    return new Menu(category, Randoms.shuffle(findMenusByCategory(category)).get(0));
  }
}
