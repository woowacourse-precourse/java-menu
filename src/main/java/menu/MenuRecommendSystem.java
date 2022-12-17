package menu;

import static menu.ReadUntilValidTemplate.read;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import menu.model.Category;
import menu.model.Coach;
import menu.model.Recommendation;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuRecommendSystem {
    public static final String COACH_SIZE_OUT_OF_RANGE = "코치는 최소 2명 이상 5명 이하로 입력해야 합니다.";
    public static final String INVALID_MENU_SIZE = "코치는 최소 0개, 최대 2개의 못 먹는 메뉴를 가집니다.";
    public static final int LAST_DAY = 5;
    public static final int MAX_SIZE_OF_MENU_INPUT = 2;
    public static final int MIN_VALUE_OF_COACH_SIZE = 2;
    public static final int MAX_VALUE_OF_COACH_SIZE = 5;
    public static final String DUPLICATE_NAME = "코치의 이름은 중복될 수 없습니다.";
    private List<Coach> coaches;
    private Recommendation recommendation;

    /**
     * 메뉴 추천 시스템 동작 메서드* 1. 시작 2. 코치 생성하기 3. 코치별 못 먹는 메뉴 입력받기 4. 메뉴 추천 5. 결과 출력하기 6. 종료 * *
     */
    public void run() {
        start();
        makeCoaches();
        for (Coach coach : coaches) {
            addMenuCannotToEat(coach);
        }
        recommend();
        showRecommendationResult();
        end();
    }

    /**
     * 시작하기*
     */
    public void start() {
        OutputView.printStartMessage();
    }

    /**
     * 반복해야할 메서드 * 코치 이름 입력받기*
     */
    private void makeCoaches() {
        coaches = read(this::createCoachesByNames, InputView::readCoachNameList);
    }

    /**
     * 반복해야할 메서드 *
     *
     * @param coach: 이름으로 생성한 코치 한 명
     */
    private void addMenuCannotToEat(Coach coach) {
        List<String> menuCannotEat = readMenuUntilValidValue(coach);

        for (String menu : menuCannotEat) {
            coach.addMenuCannotEat(menu);
        }
        if (coach.getSizeOfMenuCannotToEat() > MAX_SIZE_OF_MENU_INPUT) {
            throw new IllegalArgumentException(INVALID_MENU_SIZE);
        }
    }

    private List<String> readMenuUntilValidValue(Coach coach) {
        while (true) {
            try {
                return getMenuCannotEat(InputView.readMenuCoachCannotEat(coach.getName()));
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private List<String> getMenuCannotEat(List<String> menuInput) {
        if (menuInput.isEmpty()) {
            return menuInput;
        }
        for (String menu : menuInput) {
            validateMenu(menu);
        }
        return menuInput;
    }

    private void validateMenu(String menu) {
        Category.existsHaving(menu);
    }

    private List<Coach> createCoachesByNames(List<String> coachNameList) {
        validateCoachNames(coachNameList);
        return coachNameList.stream().map(Coach::new).collect(Collectors.toList());
    }

    private void validateCoachNames(List<String> coachNameList) {
        int coachSize = coachNameList.size();
        if (coachSize < MIN_VALUE_OF_COACH_SIZE || coachSize > MAX_VALUE_OF_COACH_SIZE) {
            throw new IllegalArgumentException(COACH_SIZE_OUT_OF_RANGE);
        }
        Set<String> coachNameSet = new HashSet<>(coachNameList);
        if (coachSize != coachNameSet.size()) {
            throw new IllegalArgumentException(DUPLICATE_NAME);
        }
    }

    /**
     * * 메뉴 추천 메서드
     */
    private void recommend() {
        recommendation = new Recommendation();
        Set<String> cannotToEat = getTotalMenuCoachCannotToEat();

        for (int dayCount = 0; dayCount < LAST_DAY; dayCount++) {
            recommendForADay(recommendation, cannotToEat);
        }
    }

    private void recommendForADay(Recommendation recommendation, Set<String> cannotToEat) {
        Category recommendedCategory = recommendation.addCategory();
        for (Coach coach : coaches) {
            coach.recommendMenu(recommendedCategory, cannotToEat);
        }
    }

    private Set<String> getTotalMenuCoachCannotToEat() {
        Set<String> result = new HashSet<>();
        for (Coach coach : coaches) {
            result.addAll(coach.getMenuCannotToEat());
        }
        return result;
    }

    /**
     * 메뉴 추천 결과 출력 메서드*
     */
    private void showRecommendationResult() {
        List<String> recommendationResult = coaches.stream()
                .map(this::recommendationToString)
                .collect(Collectors.toList());

        OutputView.printRecommendationResult(recommendation.toString(), recommendationResult);
    }

    private String recommendationToString(Coach coach) {
        String result = Stream.of(List.of(coach.getName()), coach.getRecommendationForWeek()).flatMap(
                Collection::stream).collect(
                Collectors.joining(" | "));
        return String.format("[ %s ]", result);
    }

    /**
     * 종료 메서드*
     */
    private void end() {
        OutputView.printEndMessage();
    }
}
