package menu.utils;

import menu.domain.Menu;
import menu.domain.MenuRepository;
import menu.domain.Style;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Utils {
    private static final Pattern COACH_NAME_PATTERN2 = Pattern.compile("^[가-힣]+,[가-힣]+$");
    private static final Pattern COACH_NAME_PATTERN3 = Pattern.compile("^[가-힣]+,[가-힣]+,[가-힣]+$");
    private static final Pattern COACH_NAME_PATTERN4 = Pattern.compile("^[가-힣]+,[가-힣]+,[가-힣]+,[가-힣]+$");
    private static final  Pattern CANT_EAT_PATTERN0 = Pattern.compile("");
    private static final Pattern CANT_EAT_PATTERN1 = Pattern.compile("^[가-힣]+");
    private static final Pattern CANT_EAT_PATTERN2 = Pattern.compile("^[가-힣]+,[가-힣]+$");
    private static final String REGEX = ",";

    public static Style styleToCategoryConverter(int categoryNum) {
        try {
            return Style.get(categoryNum);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return Style.한식;
        }
    }
    public static void coachPatternMatching(String input) {
        if (!COACH_NAME_PATTERN2.matcher(input).matches()
              && !COACH_NAME_PATTERN3.matcher(input).matches()
              && !COACH_NAME_PATTERN4.matcher(input).matches()) {
            throw new IllegalArgumentException("[ERROR] 이름의 형식이 올바르지 않습니다.");
        }
    }

    public static List<String> separator(String input) {
        String[] splitInput = input.split(REGEX);
        List<String> result = Arrays.stream(splitInput).collect(Collectors.toList());
        return result;
    }

    public static void cantEatPatternMatching(String input) {
        if (!CANT_EAT_PATTERN0.matcher(input).matches()
                && !CANT_EAT_PATTERN1.matcher(input).matches()
                && !CANT_EAT_PATTERN2.matcher(input).matches()) {
            throw new IllegalArgumentException("[ERROR] 못먹는 메뉴 형식이 올바르지 않습니다.");
        }
    }

    public static void initMenu() {
        List<Style> styles = Arrays.asList(Style.일식, Style.한식, Style.중식, Style.아시안, Style.양식);
        List<String> japaneseFood = Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리","하이라이스", "라멘","오코노미야끼");
        List<String> koreanFood = Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음");
        List<String> chineseFood = Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채");
        List<String> asianFood = Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠양꿍", "반미", "월남쌈", "분짜");
        List<String> westernFood = Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치", "토스트", "바게트", "스파게티", "피자", "파니니");
        List<List<String>> foods = Arrays.asList(japaneseFood, koreanFood, chineseFood, asianFood, westernFood);
        int idx = 0;
        for (List<String> food : foods) {
            pushMenu(food, styles.get(idx));
            idx += 1;
        }
    }

    public static void pushMenu(List<String> foods, Style style) {
        for (String food : foods) {
            MenuRepository.addMenu(new Menu(food, style.getCode()));
        }
    }

    public static List<Menu> convertToMenu(List<String> menus) {
        List<Menu> result = new ArrayList<>();
        List<Menu> allMenu = MenuRepository.getMenus();
        for (String name : menus) {
            Menu menu = allMenu.stream().filter(m -> m.getName().equals(name)).findFirst().get();
            result.add(menu);
        }
        return result;
    }

    public static List<String> convertToMenuName(List<Menu> menus) {
        List<String> result = new ArrayList<>();
        for (Menu menu : menus) {
            result.add(menu.getName());
        }
        return result;
    }
}
