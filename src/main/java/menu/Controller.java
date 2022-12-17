package menu;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();
    private static MenuRecommender menuRecommender = new MenuRecommender();

    public static void run() {
        showStart();

        List<String> coaches = getCoachName();
        List<Member> members = getMemberInformation(coaches);
        reflectResult(members);

        showResult();
    }

    private static void showResult() {
        outputView.printResult(menuRecommender);
    }

    private static void reflectResult(List<Member> members) {
        menuRecommender.setMembers(members);
        menuRecommender.makeRecommends();
    }

    private static List<Member> getMemberInformation(List<String> coaches) {
        List<Member> members = new ArrayList<>();

        for (String coachName : coaches) {
            outputView.printPickEatingsInformMessage(coachName);
            List<String> pickyEatings = inputView.readPickyEatings();

            members.add(new Member(coachName, pickyEatings));
        }
        return members;
    }

    private static List<String> getCoachName() {
        outputView.printCoachNameInformMessage();
        List<String> coaches = inputView.readCoachNames();
        return coaches;
    }

    private static void showStart() {
        outputView.printStartMessage();
    }
}
