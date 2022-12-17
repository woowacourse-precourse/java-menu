package view;

import domain.*;

import java.util.List;
import java.util.Map;

public final class OutputView {
    private static final String START_RECOMMEND = "점심 메뉴 추천을 시작합니다.";
    private static final String INPUT_COACH_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String INPUT_COACH_HATE_MENU = "%s(이)가 못 먹는 메뉴를 입력해 주세요.\n";

    private static final String MENU_RECOMMEND_RESULT = "메뉴 추천 결과입니다.";
    private static final String OPEN_SQUARE_BRACKET = "[ ";
    private static final String CLOSE_SQUARE_BRACKET = " ]";
    private static final String SEPERATOR = " | ";
    private static final String WHAT_DAY = "구분";
    private static final String CATEGORY = "카테고리";
    private static final String FINISH_RECOMMEND = "추천을 완료했습니다.";
    private OutputView() {}

    public static void printStartRecommend() {
        System.out.println(START_RECOMMEND);
    }

    public static void printInputCoachNames() {
        System.out.println(INPUT_COACH_NAME);
    }

    public static void printInputCoachHateMenu(Coach coach) {
        System.out.printf(INPUT_COACH_HATE_MENU, coach.getName());
    }

    public static void printRecommendResult(Result result, Coaches coaches) {
        System.out.println(MENU_RECOMMEND_RESULT);

        StringBuilder sb = new StringBuilder();
        sb.append(OPEN_SQUARE_BRACKET)
          .append(WHAT_DAY)
          .append(SEPERATOR);

        // 구분 줄 출력
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            if (dayOfWeek.isLastDayOfWeek(dayOfWeek)) {
                sb.append(dayOfWeek.getDayOfWeek())
                  .append(CLOSE_SQUARE_BRACKET);
                break;
            }
            sb.append(dayOfWeek.getDayOfWeek())
              .append(SEPERATOR);
        }
        sb.append("\n");

        // 카테고리 줄 출력
        sb.append(OPEN_SQUARE_BRACKET)
          .append(CATEGORY)
          .append(SEPERATOR);
        Map<DayOfWeek, DayCategoryMenu> results = result.getResults();
        for (DayOfWeek dayOfWeek : results.keySet()) {
            DayCategoryMenu dayCategoryMenu = results.get(dayOfWeek);
            Category category = dayCategoryMenu.getCategory();
            if (dayOfWeek.isLastDayOfWeek(dayOfWeek)) {
                sb.append(category.getName())
                  .append(CLOSE_SQUARE_BRACKET);
                break;
            }
            sb.append(category.getName())
              .append(SEPERATOR);
        }
        sb.append("\n");

        //한 사람씩 출력
        Map<DayOfWeek, DayCategoryMenu> resultMap = result.getResults();

        List<Coach> coachesName = coaches.getCoachesName();

        int lineCount = 0;
        for (Coach coach : coachesName) {
            sb.append(OPEN_SQUARE_BRACKET);
            sb.append(coach.getName())
              .append(SEPERATOR);
            for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
                DayCategoryMenu dayCategoryMenu = resultMap.get(dayOfWeek);

                List<Menu> menusName = dayCategoryMenu.getMenusName();
                Menu menu = menusName.get(lineCount);

                if (dayOfWeek.isLastDayOfWeek(dayOfWeek)) {
                    sb.append(menu.getName())
                      .append(CLOSE_SQUARE_BRACKET);
                    break;
                }
                sb.append(menu.getName())
                  .append(SEPERATOR);
            }
            lineCount++;
            sb.append("\n");
        }

        System.out.println(sb);

        System.out.println(FINISH_RECOMMEND);
    }



}
