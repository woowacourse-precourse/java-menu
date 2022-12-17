package menu;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import menu.model.Category;
import menu.model.Coach;
import menu.model.Recommendation;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuRecommendSystem {
    public static final String LESS_THAN_MIN_VALUE = "코치는 최소 2명 이상 입력해야 합니다.";
    public static final String INVALID_MENU_SIZE = "코치는 최소 0개, 최대 2개의 못 먹는 메뉴를 가집니다.";
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
     * 반복해야할 메서드 *
     * 코치 이름 입력받기*
     */
    private void makeCoaches() {
        coaches = read(this::createCoachesByNames, InputView::readCoachNameList);
    }

    /**
     * 반복해야할 메서드 *
     * @param coach: 이름으로 생성한 코치 한 명
     */
    private void addMenuCannotToEat(Coach coach) {
        List<String> menuCannotEat = readMenuUntilValidValue(coach);

        for (String menu : menuCannotEat) {
            coach.addMenuCannotEat(menu);
        }
        if (coach.getSizeOfMenuCannotToEat() > 2) {
            throw new IllegalArgumentException(INVALID_MENU_SIZE);
        }
    }

    private List<String> readMenuUntilValidValue(Coach coach) {
        while(true) {
            try{
                return getMenuCannotEat(InputView.readMenuCoachCannotEat(coach.getName()));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private List<String> getMenuCannotEat(List<String> menuInput) {
        if (menuInput.isEmpty()) {
            return menuInput;
        }
        for(String menu: menuInput) {
            validateMenu(menu);
        }
        return menuInput;
    }

    private void validateMenu(String menu) {
        Category.existsHaving(menu);
    }

    private List<Coach> createCoachesByNames(List<String> coachNameList) {
        if (coachNameList.size() < 2) {
            throw new IllegalArgumentException(LESS_THAN_MIN_VALUE);
        }
        return coachNameList.stream().map(Coach::new).collect(Collectors.toList());
    }

    /**
     * * 메뉴 추천 메서드
     */
    private void recommend() {
        recommendation = new Recommendation();
        Set<String> cannotToEat = getTotalMenuCoachCannotToEat();

        for(int i = 0; i < 5; i++) {
            recommendForADay(recommendation, cannotToEat);
        }
    }

    private void recommendForADay(Recommendation recommendation, Set<String> cannotToEat) {
        Category recommendedCategory = recommendation.addCategory();
        for(Coach coach: coaches) {
            coach.recommendMenu(recommendedCategory, cannotToEat);
        }
    }

    private Set<String> getTotalMenuCoachCannotToEat() {
        Set<String> result = new HashSet<>();
        for (Coach coach: coaches) {
            result.addAll(coach.getMenuCannotToEat());
        }
        return result;
    }

    /**
     * 메뉴 추천 결과 출력 메서드*
     */
    private void showRecommendationResult() {
        List<String> recommendationResult = coaches.stream().map(
                this::recommendationToString
        ).collect(Collectors.toList());
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

    private <T, R> R read(Function<T, R> object, Supplier<T> input) {
        while(true) {
            try {
                return object.apply(input.get());
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
