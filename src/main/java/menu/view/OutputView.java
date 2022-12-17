package menu.view;

import java.util.List;
import java.util.stream.Collectors;

import menu.model.Category;

public class OutputView {
    private enum ServiceControlMessage {
        SERVICE_START("점심 메뉴 추천을 시작합니다."),
        INPUT_COACH_NAME("\n코치의 이름을 입력해 주세요. (, 로 구분)"),
        INPUT_COACH_NOT_EAT("\n%s(이)가 못 먹는 메뉴를 입력해 주세요.\n"),
        SERVICE_RESULT("\n메뉴 추천 결과입니다."),
        SERVICE_END("\n추천을 완료했습니다.");
    
        private final String message;
        ServiceControlMessage(String message) {
            this.message = message;
        }
    
        private String getMessage() {
            return message;
        }
    }

    private static final String FRONT_BRACKET = "[ ";
    private static final String CATEGORY = "카테고리 | ";
    private static final String BACK_BRACKET = " ]";
    private static final String PATH_DELIMITER = " | ";

    public void printServiceStart() {
        System.out.println(ServiceControlMessage.SERVICE_START.getMessage());
    }

    public void printInputCoachName() {
        System.out.println(ServiceControlMessage.INPUT_COACH_NAME.getMessage());
    }
    
    public void printInputCoachNotEat(String coach) {
        System.out.printf(ServiceControlMessage.INPUT_COACH_NOT_EAT.getMessage(), coach);
    }
    
    public void printServiceResult() {
        System.out.println(ServiceControlMessage.SERVICE_RESULT.getMessage());
    }

    public void printServiceEnd() {
        System.out.println(ServiceControlMessage.SERVICE_END.getMessage());
    }

    public void printRecommendMenuResult(List<Category> categoryCheckList) {
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        List<String> categories = categoryCheckList.stream().map(category -> category.getCategoryName()).collect(Collectors.toList());;
        System.out.println(FRONT_BRACKET + CATEGORY + String.join(PATH_DELIMITER, categories) + BACK_BRACKET);
    }


    public void printRecommendMenuResultByCoach(String name, List<String> foods) {
        System.out.println(FRONT_BRACKET + name + PATH_DELIMITER + String.join(PATH_DELIMITER, foods) + BACK_BRACKET);
    }
    
}
