package menu;

import menu.model.Category;
import menu.view.InputView;

import java.util.List;
import java.util.Map;

public class MenuEngine {

    public static void main(String[] args) {
        System.out.println("점심 메뉴 추천을 시작합니다.");

        InputView inputView = new InputView();

        List<String> coachNames = inputView.readCoachName();

        Map<String, List<String>> exceptedFoods = inputView.readExceptedFood(coachNames);

        Category category = new Category();

        CategoryMaker categoryMaker = new CategoryMaker();

        categoryMaker.addCategory(category);


    }
}
