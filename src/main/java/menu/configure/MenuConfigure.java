package menu.configure;

import static menu.repository.CategoryRepository.addAllCategory;
import static menu.repository.CategoryRepository.categories;
import static menu.repository.MenuRepository.addAllMenus;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import menu.domain.Category;
import menu.domain.Menu;

public class MenuConfigure {

  private static final List<String> defaultCategoryNames = List.of("일식", "한식", "중식", "아시안", "양식");
  private static final String JAPANESE = "규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼";
  private static final String KOREAN = "김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음";
  private static final String ASIAN = "팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜";
  private static final String CHINESE = "깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채";
  private static final String AMERICAN = "라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니";
  private static final List<List<String>> menusList = Stream.of(JAPANESE, KOREAN, ASIAN, CHINESE,
          AMERICAN).map(MenuConfigure::convertToList).collect(Collectors.toList());

  public static void configure() {
    initCategories();
    initMenus();
  }

  private static void initMenus() {
    List<Category> categories = categories();
    for(int i=0; i<categories.size(); i++) {
      Category category = categories.get(i);
      addAllMenus(menusList.get(i).stream().map(menus -> new Menu(category, menus))
          .collect(Collectors.toList()));
    }
  }

  private static void initCategories() {
    List<Category> categories = defaultCategoryNames.stream().map(Category::new)
        .collect(Collectors.toList());
    addAllCategory(categories);
  }

  private static List<String> convertToList(String string) {
    return Arrays.stream(string.split(","))
        .map(String::trim)
        .collect(Collectors.toList());
  }

}
