package menu.controller;

import menu.domain.Coach;
import menu.domain.MenuRecommender;
import menu.repository.CoachRepository;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class MainController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private final CoachRepository coachRepository = new CoachRepository();

    public void run() {
        /* 서비스 시작 문구 출력 */
        outputView.printStartMessage();

        /* 사전 준비
         * - 코치 이름 입력 받기
         * - 코치별로 못 먹는 메뉴 입력 받기
         * - 코치 객체 생성 (이름, 못먹는 메뉴 세팅) */
        List<String> coachNames = inputView.readCoachNames();
        for (String coachName : coachNames) {
            List<String> noEatFoods = inputView.readNoEatFoods(coachName);
            Coach coach = new Coach(coachName, noEatFoods);
            coachRepository.save(coach);
        }

        /* 메뉴 추천 */
        MenuRecommender menuRecommender = new MenuRecommender(coachRepository);
        menuRecommender.run();

        /* 서비스 종료 문구 출력 */
        outputView.printEndMessage();
    }
}
