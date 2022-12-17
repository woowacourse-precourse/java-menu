package menu.view;

import menu.dto.RecommendationDTO;
import menu.message.NoticeMessage;
import java.util.List;

public class OutputView {
    private static final String NEW_LINE = "\n";
    private static final String FIRST_DELIMITER = "[ ";
    private static final String MID_DELIMITER = " | ";
    private static final String LAST_DELIMITER = " ]";
    private static final String CATEGORY = "카테고리";

    public void outputStartNotice() {
        System.out.println(NoticeMessage.START_MESSAGE + NEW_LINE);
    }

    public void outputRecommendation(RecommendationDTO recommendationDTO) {
        System.out.println(getRecommendation(recommendationDTO).toString());
    }

    private StringBuilder getRecommendation(RecommendationDTO recommendationDTO) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(NoticeMessage.OUTPUT_RECOMMENDATION_MENU + NEW_LINE);
        stringBuilder.append(NoticeMessage.OUTPUT_RECOMMENDATION_MENU_DAY + NEW_LINE);
        addCategory(recommendationDTO, stringBuilder);
        addCoachMenus(recommendationDTO, stringBuilder);
        stringBuilder.append(NEW_LINE + NoticeMessage.OUTPUT_RECOMMENDATION_MENU_COMPLETE);
        return stringBuilder;
    }

    private void addCoachMenus(RecommendationDTO recommendationDTO, StringBuilder stringBuilder) {
        List<String> coaches = recommendationDTO.getCoaches();
        List<List<String>> recommendedMenus = recommendationDTO.getRecommendedMenus();
        for (int coachIndex = 0; coachIndex < coaches.size(); coachIndex++) {
            stringBuilder.append(FIRST_DELIMITER + coaches.get(coachIndex));
            List<String> menus = recommendedMenus.get(coachIndex);
            for (String menu : menus) {
                stringBuilder.append(MID_DELIMITER + menu);
            }
            stringBuilder.append(LAST_DELIMITER + NEW_LINE);
        }
    }

    private void addCategory(RecommendationDTO recommendationDTO, StringBuilder stringBuilder) {
        List<String> categories = recommendationDTO.getCategories();
        stringBuilder.append(FIRST_DELIMITER + CATEGORY);
        for (String category : categories) {
            stringBuilder.append(MID_DELIMITER + category);
        }
        stringBuilder.append(LAST_DELIMITER + NEW_LINE);
    }
}
