package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;
import menu.domain.CategoryRepository;
import menu.domain.Coach;
import menu.domain.CoachRepository;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class MenuService {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public String[] askCoachNames() {
        while (true) {
            try {
                return inputView.readCoachName();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String[] askInedibleFoodName(String coachName) {
        while (true) {
            try {
                return inputView.readInedibleFoodName(coachName);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }




    public void recommend() {
        forEveryCategory();
    }

    public void forEveryCategory() {
        for (Category category : CategoryRepository.categories()) {     // 각 요일별 카테고리
            forEveryCoach(category);
        }
    }

    public void forEveryCoach(Category category) {
        for (Coach coach : CoachRepository.coaches()) {
            addCoachRecommendFood(coach, category);
        }
    }


    public void addCoachRecommendFood(Coach coach, Category category) {
        while (true) {
            List<String> menus = category.getFoods();                   // 해당 카테고리의 음식들 중
            String menu = Randoms.shuffle(menus).get(0);                // 셔플해서 첫 음식
            if (!coach.containsInedibleFood(menu) && !coach.containsRecommendedFood(menu)) {
                coach.addRecommendedFood(menu);
                break;
            }
        }
    }








    public void printServiceStart() {
        outputView.printStart();
    }

    public void printServiceExit() {
        outputView.printResult();
    }

}
