package menu.view;

import menu.domain.CouchGroup;
import menu.utils.Category;
import menu.utils.OutputMessage;
import menu.utils.Weekend;

import java.util.List;

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
        System.out.println(Weekend.toMessage());
        System.out.println(Category.toMessage(categories));
        System.out.println(couchGroup.toMessage());
        System.out.println(OutputMessage.RECOMMEND_COMPLETE.getMessage());
    }
}
