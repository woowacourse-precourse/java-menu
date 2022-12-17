package menu.view;

import static menu.configure.MenuConfigure.DAYS;
import static menu.repository.CategoryRepository.findAllCategoryNames;
import static menu.repository.CoachRepository.coaches;
import static menu.repository.RecommendationResultRepository.result;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Menu;

public class OutputView {

  private static final String ERROR_PREFIX = "[ERROR] ";
  private static final String RECOMMEND_RESULT_MESSAGE = "\n메뉴 추천 결과입니다.";
  private static final String RECOMMEND_SUCCESS_MESSAGE = "\n추천을 완료했습니다.";
  private static final String CATEGORY = "카테고리";
  public static void printErrorMessage(String message) {
    System.out.println(ERROR_PREFIX + message);
  }

  public void printResult() {
    System.out.println(RECOMMEND_RESULT_MESSAGE);
    printDays();
    printCategories();
    makeResultForm().forEach(System.out::println);
    System.out.println(RECOMMEND_SUCCESS_MESSAGE);
  }
  public void printDays() {
    List<String> result = new ArrayList<>();
    result.add("구분");
    result.addAll(DAYS);
    System.out.println(convertToResultForm(result));
  }
  public void printCategories() {
    List<String> allCategoryNames = result().get(coaches().get(0)).stream()
        .map(r -> r.getCategory().getName())
        .collect(Collectors.toList());
    List<String> result = new ArrayList<>();
    result.add(CATEGORY);
    result.addAll(allCategoryNames);
    System.out.println(convertToResultForm(result));
  }

  private List<String> makeResultForm() {
    List<String> result = new ArrayList<>();
    result().forEach((coach, menus) -> {
      List<String> temp = new ArrayList<>();
      temp.add(coach.getName());
      temp.addAll(menus.stream()
          .map(Menu::getName)
          .collect(Collectors.toList()));
      result.add(convertToResultForm(temp));
    });
    return result;
  }

  private String convertToResultForm(List<String> input) {
    return "[ " + String.join(" | ", input) + " ]";
  }
}
