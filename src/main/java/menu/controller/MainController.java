package menu.controller;

import menu.constant.Category;
import menu.constant.Day;
import menu.model.Coach;
import menu.model.Menu;
import menu.model.Recommender;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    List<Category> categories;
    List<Coach> coaches;
    Recommender recommender;

    public MainController(){
        categories = new ArrayList<>();
        recommender = new Recommender();
        coaches = new ArrayList<>();
    }

    public void execute(){
        displayStartMessage();
        setCategories();
        setCoachNames();
        for(Coach coach : coaches){
            setBanFoods(coach);
            setMenusOfWeek(coach);
        }
        displayRecommendationResult();
        displayFinishMessage();
    }

    private void displayStartMessage(){
        OutputView.printServiceStartMessage();
    }

    private void setCoachNames(){
        OutputView.printGetCoachNamesMessage();
        String[] coachNames = InputView.readCoachNames();
        for(String coachName : coachNames){
            coaches.add(new Coach(coachName));
        }
    }

    private void setBanFoods(Coach coach){
        OutputView.printGetBanFoodsMessage(coach.getName());
        String[] banFoods = InputView.readBanFoods();
        coach.setBanFoods(banFoods);
    }


    private void setCategories(){
        for(int i = 0; i < 5; i++){
            setCategoryOfDay();
        }
    }

    private void setCategoryOfDay(){
        Category recommendedCategory = recommender.recommendCategory();
        if(checkDuplicationCount(recommendedCategory) >= 2){
            setCategoryOfDay();
            return;
        }
        categories.add(recommendedCategory);
    }

    private int checkDuplicationCount(Category recommendedCategory){
        int count = 0;
        for(Category category : categories){
            if(category.equals(recommendedCategory)){
                count++;
            }
        }
        return count;
    }

    private void setMenusOfWeek(Coach coach){
        for(int i = 0; i < 5; i++){
            setMenuOfDay(Day.get(i), categories.get(i), coach);
        }
    }

    private void setMenuOfDay(Day day, Category category, Coach coach){
        String recommendedMenu = recommender.recommendMenuOfCategory(category);
        if(isDuplicatedMenu(coach, recommendedMenu)){
            setMenuOfDay(day, category, coach);
            return;
        }
        if(isBanMenu(coach, recommendedMenu)){
            setMenuOfDay(day, category, coach);
            return;
        }
        Menu menu = new Menu(day, category, recommendedMenu);
        coach.addMenu(menu);
    }

    private boolean isDuplicatedMenu(Coach coach, String recommendedMenu){
        List<Menu> menusOfCoach = coach.getMenusOfWeek();
        for(Menu menu : menusOfCoach){
            if(menu.getMenuName().equals(recommendedMenu)){
                return true;
            }
        }
        return false;
    }

    private boolean isBanMenu(Coach coach, String recommendedMenu){
        String[] banFoods = coach.getBanFoods();
        for(String banFood : banFoods){
            if(banFood.equals(recommendedMenu)){
                return true;
            }
        }
        return false;
    }

    private void displayRecommendationResult(){
        OutputView.printRecommendationResultMessage();
        OutputView.printDays();
        OutputView.printCategories(categories);
        for(Coach coach : coaches){
            OutputView.printRecommendedMenus(coach);
        }
    }

    private void displayFinishMessage(){
        OutputView.printServiceFinishMessage();
    }
}
