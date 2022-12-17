package menu.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import menu.view.InputView;
import menu.view.OutputView;

public class Coach {
    private static final String INVALID_NAME_RANGE = "[ERROR] 코치의 이름은 2글자 이상 4글자 이하입니다.";
    private static final String INVALID_UNEATABLE_SIZE = "[ERROR] 못먹는 메뉴는 0개에서 2개 범위를 넘을 수 없습니다.";
    private static final String DUPLICATED = "[ERROR] 중복을 제거해주세요";
    private List<String> prohibitionMenus = new ArrayList<String>();
    private List<String> recommendMenus = new ArrayList<String>();
    private String name;

    public Coach(String name) {
        if (!(2 <= name.length() && name.length() <= 4)) {
            throw new IllegalArgumentException(INVALID_NAME_RANGE);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getFormat() {
        return OutputView.COACH_LINE_START + name + OutputView.RESULT_SEPERATOR + recommendMenus.stream()
                .collect(Collectors.joining(OutputView.RESULT_SEPERATOR))
                + OutputView.LINE_END;
    }

    public void setRecommendMenus(Week week) {
        String recommendMenu = Category.recommendRandomMenu(week.getCategory());
        while (isEatable()) {
            recommendMenu = Category.recommendRandomMenu(week.getCategory());
        }
        recommendMenus.add(recommendMenu);
    }

    private void validateUnEatableMenus(String[] inputProhibitionMenus) {
        if (!(0 <= inputProhibitionMenus.length && inputProhibitionMenus.length <= 2)) {
            throw new IllegalArgumentException(INVALID_UNEATABLE_SIZE);
        }
        if (inputProhibitionMenus.length != (new HashSet<String>(List.of(inputProhibitionMenus))).size()) {
            throw new IllegalArgumentException(DUPLICATED);
        }

    }
    public void setProhibitionMenus(String menus) {
        String[] inputProhibitionMenus = menus.split(InputView.INPUT_SEPARATOR);

        validateUnEatableMenus(inputProhibitionMenus);

        for (String menu : inputProhibitionMenus) {
            Category.validateMenu(menu);
            prohibitionMenus.add(menu);
        }
    }

    public boolean isEatable() {
        int prohibitMenuCount = (int) recommendMenus.stream()
                .filter(menu -> prohibitionMenus.contains(menu))
                .count();
        int duplicatedCount = new HashSet<String>(recommendMenus).size();
        return prohibitMenuCount == 0 && duplicatedCount == 5;
    }


}
