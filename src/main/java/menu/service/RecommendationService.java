package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.model.Category;
import menu.model.Coach;
import menu.model.Menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RecommendationService {

  private final int categoryStartInclusive = 1;
  private final int categoryEndInclusive = Category.values().length;
  private final int dayOfWeekNum = 5;

  private List<Integer> categoryResult = new ArrayList<>();
  private List<List<String>> menuResult = new ArrayList<>();

  public String getRecommendationResult(List<Coach> coaches) {
    makeRandomMenu(coaches);
    StringBuilder builder = new StringBuilder();
    List<String> categoriesInKorean = categoryResult.stream().map(Category::getCategoryInKorean).collect(Collectors.toList());
    builder.append("[ 카테고리 | ").append(String.join(" | ", categoriesInKorean)).append(" ]\n");
    for (int i = 0; i < coaches.size(); i++) {
      builder.append("[ ").append(coaches.get(i).getName()).append(" | ").append(String.join(" | ", menuResult.get(i))).append(" ]\n");
    }
    return builder.toString();
  }

  public List<List<String>> makeRandomMenu(List<Coach> coaches) {
    makeRandomCategory();
    initializeMenuResult();
    for (int i = 0; i < coaches.size(); i++) {
      List<String> coachHateFood = coaches.get(i).getHateFood();
      // 카테고리마다 랜덤으로 메뉴를 불러와서 그걸 셔플을 돌려서 0번쨰 인자 가져와
      // 만약 싫어하는 음식이면 다시 돌려
      menuResult.add(generateRandomMenu(coachHateFood));
    }
    return menuResult;
  }

  private List<String> generateRandomMenu(List<String> coachHateFood) {
    List<String> menus = new ArrayList<>();
    for (int j = 0; j < categoryResult.size(); j++) {
      String randomMenu = Randoms.shuffle(Menu.getMenus(Category.getCategory(categoryResult.get(j)))).get(0);
      if (menus.contains(randomMenu) || coachHateFood.contains(randomMenu)) {
        --j;
        continue;
      }
      menus.add(randomMenu);
    }
    return menus;
  }

  private List<Integer> makeRandomCategory() {
    List<Integer> categoryCount = new ArrayList<>();
    initializeCategoryCount(categoryCount);
    for (int i = 0; i < dayOfWeekNum; i++) {
//      String category = categories.get(Randoms.pickNumberInRange(1, 5));
      int categoryNum = Randoms.pickNumberInRange(categoryStartInclusive, categoryEndInclusive);
      if (categoryCount.get(categoryNum) > 1) {
        --i;
        continue;
      }
      int currCount = categoryCount.get(categoryNum);
      categoryCount.set(categoryNum, ++currCount);
      categoryResult.add(categoryNum);
    }
    return categoryResult;
  }

  private void initializeCategoryCount(List<Integer> categoryCount) {
    for (int i = 0; i < dayOfWeekNum + 1; i++) {
      categoryCount.add(i, 0);
    }
  }

  private void initializeMenuResult() {
    for (int i = 0; i < menuResult.size(); i++) {
      menuResult.add(new ArrayList<>());
    }
  }
}
