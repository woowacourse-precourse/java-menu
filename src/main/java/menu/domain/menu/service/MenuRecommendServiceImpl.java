package menu.domain.menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import menu.domain.menu.dto.MenuRecommendResponse;
import menu.domain.menu.model.Coach;
import menu.domain.menu.model.Food;
import menu.domain.menu.repository.CategoryHistoryRepository;
import menu.domain.menu.repository.FoodRepository;
import menu.domain.menu.type.Category;

public class MenuRecommendServiceImpl implements MenuRecommendService {

    private final FoodRepository foodRepository;
    private final CategoryHistoryRepository categoryHistoryRepository;

    public MenuRecommendServiceImpl(FoodRepository foodRepository,
        CategoryHistoryRepository categoryHistoryRepository) {
        this.foodRepository = foodRepository;
        this.categoryHistoryRepository = categoryHistoryRepository;
    }

    @Override
    public List<MenuRecommendResponse> menuRecommend(List<Coach> coaches) {
        List<MenuRecommendResponse> recommendResponses = new ArrayList<>();
        for (Coach coach : coaches) {
            recommendResponses.add(new MenuRecommendResponse(coach, new ArrayList<>()));
        }
        for (int i = 0; i < 5; i++) {
            menuRecommendOneDay(recommendResponses);
        }
        return recommendResponses;
    }

    private void menuRecommendOneDay(List<MenuRecommendResponse> recommendResponses) {
        Category category = drawCategory();
        for (MenuRecommendResponse recommendResponse : recommendResponses) {
            Food food = getFood(recommendResponse, category);
            recommendResponse.getFoods().add(food);
        }
    }

    private Food getFood(MenuRecommendResponse recommendResponse, Category category) {
        Food result = null;
        Coach coach = recommendResponse.getCoach();
        while (result == null) {
            Food food = foodRecommend(category, coach);
            if (!recommendResponse.getFoods().contains(food)) {
                result = food;
            }
        }
        return result;
    }


    private Category drawCategory() {
        Category result = null;
        while (result == null) {
            int randomNumber = Randoms.pickNumberInRange(1, 5);
            Category category = Category.findByNumber(randomNumber);
            if (!categoryHistoryRepository.existTwice(category)) {
                result = category;
            }
        }
        return result;
    }

    private Food foodRecommend(Category category, Coach coach) {
        Food result = null;
        List<String> foodNames = getFoodNames(category);
        while (result == null) {
            Food food = foodRepository.findByName(Randoms.shuffle(foodNames).get(0));
            if (!coach.getForbiddenFood().contains(food)) {
                result = food;
            }
        }
        return result;
    }

    private List<String> getFoodNames(Category category) {
        List<Food> foods = foodRepository.findByCategory(category);
        List<String> foodNames = new ArrayList<>();
        for (Food food : foods) {
            foodNames.add(food.getName());
        }
        return foodNames;
    }
}
