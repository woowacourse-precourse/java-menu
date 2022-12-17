package menu;

import java.util.List;
import java.util.stream.Collectors;
import menu.model.Coach;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuRecommendSystem {
    public static final String LESS_THAN_MIN_VALUE = "코치는 최소 2명 이상 입력해야 합니다.";
    private List<Coach> coaches;
    /**
     * 메뉴 추천 시스템 동작 메서드*
     * 1. 시작
     * 2. 코치 생성하기
     * 3. 코치별 못 먹는 메뉴 입력받기
     * 4. 메뉴 추천
     * 5. 결과 출력하기
     * 6. 종료
     * * *
     */
    public void run() {
        start();
        makeCoaches();
        for(Coach coach: coaches) {
            addMenuCannotToEat(coach);
        }
    }
    /**
     * 시작하기*
     */
    public void start() {
        OutputView.printStartMessage();
    }

    /**
     * 코치 이름 입력받기*
     */
    private void makeCoaches() {
        coaches = createCoachesByNames();
    }

    private void addMenuCannotToEat(Coach coach) {
        OutputView.setPromptForMenuCannotToEatInput(coach.getName());
        List<String> menuCannotEat = InputView.readMenuCoachCannotEat();
        for(String menu: menuCannotEat) {
            coach.addMenuCannotEat(menu);
        }
    }

    private static List<Coach> createCoachesByNames() {
        List<String> coachNameList = InputView.readCoachNameList();
        if (coachNameList.size() < 2) {
            throw new IllegalArgumentException(LESS_THAN_MIN_VALUE);
        }
        return InputView.readCoachNameList().stream().map(Coach::new).collect(Collectors.toList());
    }
}
