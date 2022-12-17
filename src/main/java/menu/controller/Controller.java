package menu.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.view.InputView;
import menu.view.OutputView;

public class Controller {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Coaches coaches;

    public Controller() {
        outputView.printRecommendationStart();
        coaches = new Coaches();
    }

    public void run() {
        final Map<String, List<String>> results = new LinkedHashMap<>();
        final List<String> coachNames = repeat(this::toCrewNames);
        final List<String> categories = new ArrayList<>();
        coaches.addAll(repeat(this::toCoaches, coachNames));
        coaches.getCoaches().forEach(coach -> {
            final List<String> weeklyRecommendations = new ArrayList<>();
            for (int index = 0; index < 5; index++) {
                final String randomCategory = Category.findCategoryNameBy(Randoms.pickNumberInRange(1, 5));
                while (!categories.contains(randomCategory) && !hasMoreThanTwoCategories(categories, randomCategory)) {
                    categories.add(randomCategory);
                }
            }
            categories.forEach(category -> {
                updateWeeklyRecommendations(coach, category, weeklyRecommendations);
            });
            results.put(coach.getName(), weeklyRecommendations);
        });
        outputView.printResultsTitle(categories);
        outputView.printResults(results);
        outputView.printEnd();
    }

    private void updateWeeklyRecommendations(Coach coach, String category, List<String> weeklyRecommendations) {
        List<String> menus = new ArrayList<>(Category.findCategoryBy(category));
        menus.addAll(coach.getBannedFoods());
        String menu = Randoms.shuffle(menus).get(0);
        while (weeklyRecommendations.contains(menu)) {
            menu = Randoms.shuffle(menus).get(0);
        }
        weeklyRecommendations.add(menu);
    }

    private boolean hasMoreThanTwoCategories(List<String> categories, String giveCategory) {
        return 1 < (int) categories.stream().filter(category ->
                        category.equals(giveCategory))
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
            outputView.printErrorMessage(e.getMessage());
            return repeat(inputReader);
        }
    }

    private <T, R> R repeat(Function<T, R> service, T parameter) {
        try {
            return service.apply(parameter);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return service.apply(parameter);
        }
    }
}
