package menu.logic;

import menu.domain.Menu;
import menu.domain.Recommend;
import menu.dto.CoachWeekMenu;
import menu.enums.FoodCategory;
import menu.utils.Constant;
import menu.view.InputView;
import menu.view.OutputView;
import menu.vo.Coach;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final Recommend recommend;
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(Recommend recommend) {
        this.recommend = recommend;
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    // 메뉴 추천 기능
    public void recommendMenu() throws IllegalArgumentException{
        List<Coach> coaches = inputView.getCoachNotEat(inputView.getCoachName());
        List<CoachWeekMenu> coachWeekMenus = makeCoachWeekMenu(coaches);
        Menu menu;

        for (int i = 0; i < Constant.weekNum; i++) {
            FoodCategory foodCategory = recommend.recommendCategory();
            menu = new Menu(foodCategory);
            coachWeekMenus = menu.chooseShuffleMenu(coachWeekMenus);
        }
        outputView.printMenuResult(recommend.getWeekCategory(),coachWeekMenus);
    }

    // 코치 리스트로 CoachWeekMenu 생성
    private List<CoachWeekMenu> makeCoachWeekMenu(List<Coach> coaches) {
        List<CoachWeekMenu> coachWeekMenus = new ArrayList<>();
        for (Coach coach : coaches) {
            coachWeekMenus.add(new CoachWeekMenu(coach));
        }
        return coachWeekMenus;
    }

}
