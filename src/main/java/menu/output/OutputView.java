package menu.output;

import menu.model.Category;
import menu.model.Coach;
import menu.model.MenuConstant;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.\n";
    private static final String COACH_NAME_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String NOT_EAT_MENUS_MESSAGE = "(이)가 못 먹는 메뉴를 입력해 주세요.";
    private static final String RESULT_MESSAGE = "\n메뉴 추천 결과입니다.";
    public static final String DAY_MESSAGE = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    public static final String CATEGORY = "카테고리";
    public static final String END_MESSAGE = "\n추천을 완료했습니다.";
    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printCoachNameMessage() {
        System.out.println(COACH_NAME_MESSAGE);
    }

    public static void printEachCoachNotEatMenusMessage(String coachName) {
        System.out.println("\n" + coachName + NOT_EAT_MENUS_MESSAGE);
    }

    public static void printResult(List<Coach> coaches) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(DAY_MESSAGE);
        List<String> categories = convertCategoryToString(coaches.get(0).getCategory());
        System.out.println(convertFormat(CATEGORY, categories));
        for(Coach coach : coaches) {
            System.out.println(convertFormat(coach.getName(), coach.getRecommendedMenus()));
        }
        System.out.println(END_MESSAGE);
    }

    private static String convertFormat(String firstString, List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ " + firstString);
        for (String string : list) {
            stringBuilder.append(" | " + string);
        }
        stringBuilder.append(" ]");

        return stringBuilder.toString();
    }

    private static List<String> convertCategoryToString(List<Integer> categoryNumbers) {
        List<String> categoryString = new ArrayList<>();
        for(Integer categoryNumber : categoryNumbers) {
            categoryString.add(getCountry(categoryNumber));
        }
        return categoryString;
    }

    private static String getCountry(int country) {
        if(country == CountryConstant.JAPAN) {
            return CountryConstant.JAPAN_FOOD;
        }
        if(country == CountryConstant.KOREA) {
            return CountryConstant.KOREA_FOOD;
        }
        if(country == CountryConstant.CHINA) {
            return CountryConstant.CHINA_FOOD;
        }
        if(country == CountryConstant.ASIA) {
            return CountryConstant.ASIA_FOOD;
        }
        return CountryConstant.WEST_FOOD;
    }
}

