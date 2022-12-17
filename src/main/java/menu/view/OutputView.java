package menu.view;

import menu.domain.CouchGroup;
import menu.utils.Category;
import menu.utils.OutputMessage;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {

    public void printInitRecommend() {
        System.out.println(OutputMessage.INIT_PROGRAM.getMessage());
    }

    public void printReadCouchName() {
        System.out.println(OutputMessage.INPUT_COUCH_NAME.getMessage());
    }

    public void printReadDeniedFood(String name) {
        System.out.printf(OutputMessage.INPUT_COUCH_CANNOT_EAT.getMessage(), name);
    }

    public void printResult(CouchGroup couchGroup, List<Category> categories) {
        System.out.println(OutputMessage.RECOMMEND_RESULT.getMessage());

        StringJoiner categoryMessage = getCategoryMessage(categories);
        String couchMessage = couchGroup.toMessage();

        System.out.println(
                "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]\n" +
                        "[ 카테고리 | " + categoryMessage + " ]\n" +
                        couchMessage);

        System.out.println("추천을 완료했습니다.");
    }


    private StringJoiner getCategoryMessage(List<Category> categories) {
        StringJoiner categoryMessage = new StringJoiner(" | ");
        categories.forEach(category -> categoryMessage.add(category.getMessage()));
        return categoryMessage;
    }
}
