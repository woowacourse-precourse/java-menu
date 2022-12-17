package menu.controller;

import menu.constant.Category;
import menu.constant.Day;
import menu.model.Coach;
import menu.model.Menu;
import menu.model.Recommender;
import menu.view.InputView;
import menu.view.OutputView;
import org.junit.jupiter.params.ParameterizedTest;

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
        /*
        for(Coach coach : coaches){
            setBanFoods(coach);
            setMenusOfWeek(coach); //이거 같이하면 테스트에서 들어오는 리스트 순서 때문에 테스트 오류남
        }
        */
        for(Coach coach : coaches){
            setBanFoods(coach);
        }
        for(int i = 0; i < Day.size(); i++){
            setMenusOfDayForALLCoach(Day.get(i));
        }
        displayRecommendationResult();
        displayFinishMessage();
    }

    private void displayStartMessage(){
        OutputView.printServiceStartMessage();
    }

    private void setCoachNames(){
        try{
            OutputView.printGetCoachNamesMessage();
            String[] coachNames = InputView.readCoachNames();
            for(String coachName : coachNames){
                coaches.add(new Coach(coachName));
            }
        }catch(IllegalArgumentException e){
            OutputView.printErrorMessage(e.getMessage());
            setCoachNames();
        }
    }

    private void setBanFoods(Coach coach){
        try{
            OutputView.printGetBanFoodsMessage(coach.getName());
            String[] banFoods = InputView.readBanFoods();
            coach.setBanFoods(banFoods);
        }catch(IllegalArgumentException e){
            OutputView.printErrorMessage(e.getMessage());
            setBanFoods(coach);
        }
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

    private void setMenusOfDayForALLCoach(Day day){
        for(int i = 0; i < coaches.size(); i ++){
            setMenuOfDay(day, categories.get(i), coaches.get(i));
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
        coach.addMenu(menu, day);
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
