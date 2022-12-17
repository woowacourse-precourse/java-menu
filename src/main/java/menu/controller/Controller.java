package menu.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.view.InputView;

public class Controller {

    private final InputView inputView = new InputView();
    // private final OutputView outputView = new OutputView();
    private final Coaches coaches;

    public Controller() {
        // outputView.printGameStart();
        coaches = new Coaches();
    }

    public List<List<String>> run() {
        final List<String> coachNames = repeat(this::toCrewNames);
        coaches.addAll(repeat(this::toCoaches, coachNames));
        return coaches.getCoaches().stream().map(coach -> {
            final List<String> weeklyRecommendations = new ArrayList<>();
            for (int day = 0; day < 5; day++) {
                while (true) {
                    List<String> menus = new ArrayList<>(Category.findFoodBy(Randoms.pickNumberInRange(1, 5)));
                    menus.addAll(coach.getBannedFoods());
                    menus = menus.stream().distinct().collect(Collectors.toList());
                    String menu = Randoms.shuffle(menus).get(0);
                    if (!weeklyRecommendations.contains(menu) && !hasMoreThanTwoCategories(weeklyRecommendations, menu)) {
                        weeklyRecommendations.add(menu);
                        break;
                    }
                }
            }
            return weeklyRecommendations;
        }).collect(Collectors.toList());
    }

    private boolean hasMoreThanTwoCategories(List<String> weeklyRecommendations, String menu) {
        return 1 < (int) weeklyRecommendations.stream().filter(recommendation ->
                        Category.findNumberBy(recommendation) == Category.findNumberBy(menu))
                .count();
    }

    private List<String> toCrewNames() {
        return inputView.readCrewNames();
    }

    private List<String> toBannedFoods(String coachName) {
        return inputView.readBannedFoods(coachName);
    }

    private List<Coach> toCoaches(List<String> coachNames) {
        return coachNames.stream().map(coachName -> {
            final List<String> bannedFoods = repeat(this::toBannedFoods, coachName);
            return new Coach(coachName, bannedFoods);
        }).collect(Collectors.toList());
    }

    private <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            //  outputView.printErrorMessage(e.getMessage());
            return repeat(inputReader);
        }
    }

    private <T, R> R repeat(Function<T, R> service, T parameter) {
        try {
            return service.apply(parameter);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            // outputView.printException(e.getMessage());
            return service.apply(parameter);
        }
    }
}
