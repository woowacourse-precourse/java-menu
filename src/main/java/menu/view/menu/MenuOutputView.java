package menu.view.menu;

import java.util.List;
import java.util.Map;
import menu.dto.menu.RecommendMenusDto;
import menu.view.DefaultOutputView;

public class MenuOutputView extends DefaultOutputView {

    private static final String GUIDE_RECOMMEND_MENU_MESSAGE = "메뉴 추천 결과입니다.";
    private static final String GUIDE_STANDARD_DAYS = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";

    private static final String LOG_FORMAT = "[ %s ]";
    private static final String LOG_SEPARATOR = " | ";

    private MenuOutputView() {
    }

    private static class MenuOutputViewSingletonHelper {
        private static final MenuOutputView SINGLETON = new MenuOutputView();
    }

    public static MenuOutputView getInstance() {
        return MenuOutputViewSingletonHelper.SINGLETON;
    }

    public void recommendLunchMenu(RecommendMenusDto dto) {
        System.out.println(GUIDE_RECOMMEND_MENU_MESSAGE);
        System.out.println(GUIDE_STANDARD_DAYS);

        String categoriesLog = String.format(LOG_FORMAT, String.join(LOG_SEPARATOR, dto.getRecommendCategories()));
        System.out.println(categoriesLog);
        Map<String, List<String>> recommendMenus = dto.getRecommendMenus();
        recommendMenus.keySet().stream()
                .map(coachName ->
                        coachName.concat(LOG_SEPARATOR).concat(String.join(LOG_SEPARATOR, recommendMenus.get(coachName))))
                .forEach(recommendMenusLog -> System.out.println(formatRecommendMenusLog(recommendMenusLog)));
    }

    private String formatRecommendMenusLog(String recommendMenusLog) {
        return String.format(LOG_FORMAT, recommendMenusLog);
    }
}
