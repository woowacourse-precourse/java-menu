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
  private String[][] result;

  public String getRecommendationResult(List<Coach> coaches) {
    makeRandomMenu(coaches);
    StringBuilder builder = new StringBuilder();
    List<String> categoriesInKorean = categoryResult.stream().map(Category::getCategoryInKorean).collect(Collectors.toList());
    builder.append("[ 카테고리 | ").append(String.join(" | ", categoriesInKorean)).append(" ]\n");
    String[][] printResult = new String[coaches.size()][dayOfWeekNum];
    for (int i = 0; i < coaches.size(); i++) {
      for (int j = 0; j < dayOfWeekNum; j++) {
        printResult[i][j] = result[j][coaches.size() - 1 - i];
      }
    }
    for (int i = printResult.length-1; i > -1; i--) {
      builder.append("[ ").append(coaches.get(i).getName()).append(" | ").append(String.join(" | ", printResult[i])).append(" ]\n");
    }
    return builder.toString();
  }

  public void makeRandomMenu(List<Coach> coaches) {
    makeRandomCategory();
    result = new String[dayOfWeekNum][coaches.size()];
    for (int i = 0; i < dayOfWeekNum; i++) {
      for (int j = 0; j < coaches.size(); j++) {
        List<String> hateFood = coaches.get(j).getHateFood();
        String menu = Randoms.shuffle(Menu.getMenus(Category.getCategory(categoryResult.get(i)))).get(0);
        boolean isExist = false;
        for (int k = 0; k < result[i].length; k++) {
          if(result[i][j] == null) break;
          if (result[i][j].equals(menu) || hateFood.contains(result[i][j])) {
            isExist = true;
          }
        }
        if (isExist) {
          --j;
          continue;
        }
        result[i][j] = menu;
      }
    }

  }

//  private List<String> generateRandomMenu(List<String> coachHateFood) {
//    List<String> menus = new ArrayList<>();
//    for (int j = 0; j < categoryResult.size(); j++) {
//      String randomMenu = Randoms.shuffle(Menu.getMenus(Category.getCategory(categoryResult.get(j)))).get(0);
//      if (menus.contains(randomMenu) || coachHateFood.contains(randomMenu)) {
//        --j;
//        continue;
//      }
//      menus.add(randomMenu);
//    }
//    return menus;
//  }

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

}
