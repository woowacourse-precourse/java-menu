package menu.view.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FormatMaker {
    private static final String MAP_FORMAT = "[%s]";
    private static final String CELL_FORMAT = " %s ";
    private static final String DISPLAY_DELIMITER = "|";
    public static final String CATEGORY = "카테고리";

    public static final String DAILY_CATEGORIES_INDEX = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";

    public static String makeMenuResultsDisplay(List<String> dailyCategories, Map<String, List<String>> coachMenus) {
        String categoryDisplay = makeCategoriesDisplay(dailyCategories);
        String coachMenuDisplays = makeCoachMenusDisplays(coachMenus);
        return DAILY_CATEGORIES_INDEX + System.lineSeparator()
                + categoryDisplay + System.lineSeparator() + coachMenuDisplays;
    }

    private static String makeCategoriesDisplay(List<String> categories) {
        List<String> cells = new ArrayList<>();
        cells.add(CATEGORY);
        cells.addAll(categories);
        return String.format(MAP_FORMAT, String.join(DISPLAY_DELIMITER, formatCells(cells)));
    }

    private static String makeCoachMenusDisplays(Map<String, List<String>> coachMenus) {
        List<String> coachMenusDisplays = coachMenus.entrySet()
                .stream()
                .map(coachMenu -> makeCoachMenusDisplay(coachMenu.getKey(), coachMenu.getValue()))
                .collect(Collectors.toList());
        return String.join(System.lineSeparator(), coachMenusDisplays);
    }

    private static String makeCoachMenusDisplay(String name, List<String> menus) {
        List<String> cells = new ArrayList<>();
        cells.add(name);
        cells.addAll(menus);
        return String.format(MAP_FORMAT, String.join(DISPLAY_DELIMITER, formatCells(cells)));
    }

    private static List<String> formatCells(List<String> cells) {
        return cells.stream()
                .map(cell -> String.format(CELL_FORMAT, cell))
                .collect(Collectors.toList());
    }
}
