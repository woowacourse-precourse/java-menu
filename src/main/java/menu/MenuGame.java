package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import menu.ui.InputView;
import menu.ui.OutputView;

public class MenuGame {

    private List<Coach> coaches;
    private Stack<String> menuCategoryForEachDay;

    public void start() {
        OutputView.printMenuGameStart();
        play();
    }

    private void play() {
        createCoaches();
        enterCoachesAllergicMenus();
        createMenuCategory();
        selectCoachesMenus();
        OutputView.printMenuGameResult(menuCategoryForEachDay, coaches);

    }

    private void selectCoachesMenus() {
        for(Coach coach : coaches)
            coach.selectMenus(menuCategoryForEachDay);


    }

    private void createMenuCategory() {
        MenuCategory menuCategory = new MenuCategory();
        this.menuCategoryForEachDay = menuCategory.createMenuForEachDay();
    }

    private void enterCoachesAllergicMenus() {
        for(Coach coach : this.coaches){
            coach.enterAllergicMenus();
        }
    }

    private void createCoaches() {
        List<String> coachesNameOrigin;
        do{
            coachesNameOrigin = List.of((InputView.readCoachesName()).split(","));
        }while(!isValidCoachesName(coachesNameOrigin));

        this.coaches =  makeCoaches(coachesNameOrigin);
    }

    private List<Coach> makeCoaches(List<String> coachesNameOrigin) {
        List<Coach> coaches = new ArrayList<>();
        for(String coach : coachesNameOrigin){
            coaches.add(new Coach(coach));
        }
        return coaches;
    }

    private boolean isValidCoachesName(List<String> coachesNameOrigin) {
        if(!isValidCoachesCount(coachesNameOrigin) || !isValidCoachName(coachesNameOrigin))
            return false;
        return true;
    }

    private boolean isValidCoachName(List<String> coachesNameOrigin) {
        for(String coachName : coachesNameOrigin){
            if(!(coachName.length() >= 2 && coachName.length() <= 4))
                throw new IllegalArgumentException("[ERROR] 코치 이름의 길이가 올바르지 않습니다.");
        }
        return true;
    }

    private boolean isValidCoachesCount(List<String> coachesNameOrigin) {
        if((coachesNameOrigin.size() >= 2) && (coachesNameOrigin.size() <= 5))
            return true;
        throw new IllegalArgumentException("[ERROR] 멤버의 수가 적절하지 않습니다. (최소 2명, 최대 5명)");
    }
}
