package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.*;
import menu.dto.CoachInputDTO;
import menu.dto.RecommendResultDTO;
import menu.dto.UnavailableMenuDTO;

import java.util.List;

public class MenuService {

    private static final int WEEK_DAY = 5;

    private Coaches coaches;
    private Categories categories;
    private RecommendCategory recommendCategory;
    private RecommendMenu recommendMenu;

    public void init() {
        coaches = new Coaches();
        categories = Categories.createCategoryList();
        recommendCategory = new RecommendCategory();
    }

    public void createCoaches(CoachInputDTO coachInputDTO) {
        List<String> coachNames = coachInputDTO.getCoachNames();
        for (String coachName : coachNames) {
            coaches.addCoach(Coach.createCoach(coachName));
        }
    }

    public List<String> findAllCoachNames() {
        return coaches.getAllCoachesNames();
    }

    public void addUnavailableMenus(String coachName, UnavailableMenuDTO unavailableMenuDTO) {
        Coach coach = coaches.findByName(coachName);
        coach.addUnavailableMenu(unavailableMenuDTO.getUnavailableMenus());
    }

    public RecommendResultDTO recommend() {
        RecommendResultDTO recommendResultDTO = new RecommendResultDTO(coaches);
        for (int weekdays = 0; weekdays < WEEK_DAY; weekdays++) {
            Category category = addRecommendCategory();
            recommendResultDTO.addCategory(category.getCategoryName());
            addRecommendMenu(category);
        }
        recommendResultDTO.addMenus(coaches, recommendMenu);
        return recommendResultDTO;
    }

    private Category addRecommendCategory() {
        int randomNumber;
        Category category;
        do {
            randomNumber = Randoms.pickNumberInRange(1, 5);
            category = categories.getCategory(randomNumber);
        } while (recommendCategory.hasCategoryTwoMores(category));
        return  category;
    }

    private void addRecommendMenu(Category category) {
        List<String> coachNames = coaches.getCoachNames();
        recommendMenu = RecommendMenu.createRecommendMenu(coaches);
        for (String coachName : coachNames) {
            Coach coach;
            String menu;
            do {
                coach = coaches.findByName(coachName);
                List<String> menus = category.getMenus();
                menu = Randoms.shuffle(menus).get(0);
            } while (!availableMenu(coach, menu));
            recommendMenu.addRecommendMenu(coach, menu);
        }
    }

    private boolean availableMenu(Coach coach, String menu) {
        return !coach.canNotEatMenu(menu) &&
                !recommendMenu.containMenu(coach, menu);
    }

}
