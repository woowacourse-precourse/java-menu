package menu.service;

import static menu.repository.CategoryRepository.categories;
import static menu.repository.CategoryRepository.findAllCategoryNames;
import static menu.repository.CoachRepository.addAllCoaches;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;

public class MenuRecommendationService {

  private static final int DAYS = 5;

  public void recommend() {
    Category randomCategory = getRandomCategory();
  }

  private Category getRandomCategory() {
    return new Category(findAllCategoryNames().get(Randoms.pickNumberInRange(1, 5)));
  }
}
