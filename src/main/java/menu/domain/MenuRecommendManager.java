package menu.domain;

import menu.repository.CoachRepository;
import menu.repository.FoodRepository;
import menu.util.CategoryRecommender;
import menu.util.RandomFoodRecommend;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class MenuRecommendManager {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final CoachRepository coachRepository = new CoachRepository();
    private final FoodRepository foodRepository = new FoodRepository();

    public void executeRecommendMenu() {
        try {
            askCoachNames();
            askCoachHateFood();
            MenuRecommendResult recommendResult = createMenu();
            announceRecommendResult(recommendResult);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void announceRecommendResult(MenuRecommendResult recommendResult) {
        outputView.printRecommendMenuResult(recommendResult);
    }

    private MenuRecommendResult createMenu() {
        List<Coach> findCoaches = coachRepository.findAll();
        List<Day> days = Day.loadAllDays();
        List<Category> categories = CategoryRecommender.recommendCategories();
        for (int count = 0; count < 5; count++) {
            for (Coach coach : findCoaches) {
                getRecommendFood(coach, days.get(count), categories.get(count));
            }
        }
        return new MenuRecommendResult(days, findCoaches, categories);
    }

    private void askCoachNames() {
        List<Coach> coaches = inputView.requestCoachesNames();
        coaches.forEach(coachRepository::addCoach);
    }

    private void askCoachHateFood() {
        List<Coach> findCoaches = coachRepository.findAll();
        for (Coach coach : findCoaches) {
            handleCoachHateFood(coach);
        }
    }

    private void handleCoachHateFood(Coach coach) {
        while (true) {
            try {
                List<String> foodNames = inputView.requestCoachHateFoods(coach);
                List<Food> findFoods = foodRepository.findFoodsByNames(foodNames);
                coach.addCoachHateFoods(findFoods);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                coach.clearHateFood();
            }
        }
    }

    private void getRecommendFood(Coach coach, Day day, Category category) {
        List<String> categoryFoods = foodRepository.loadAllFoodNamesByCategory(category);
        while (true) {
            String recommendedFoodName = RandomFoodRecommend.randomRecommendFood(categoryFoods);
            Food recommendedFood = foodRepository.findFoodBy(category, recommendedFoodName);
            if (coach.isFoodOk(recommendedFood)) {
                coach.addRecommendedFood(day, recommendedFood);
                return;
            }
        }
    }
}
