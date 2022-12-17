package menu;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();
    private static MenuRecommender menuRecommender = new MenuRecommender();

    public static void run() {

        //게임 시작
        outputView.printStartMessage();

        //코치 이름 입력받기
        outputView.printCoachNameInformMessage();
        List<String> coaches = inputView.readCoachNames();
        List<Member> members = new ArrayList<>();

        //편식 음식 입력받기
        for (String coachName : coaches) {
            outputView.printPickEatingsInformMessage(coachName);
            List<String> pickyEatings = inputView.readPickyEatings();

            members.add(new Member(coachName, pickyEatings));
        }
        menuRecommender.setMembers(members);

        menuRecommender.makeRecommends();

        outputView.printResult(menuRecommender);

        return;
    }

    public static void main(String[] args) {
        run();
    }
}
