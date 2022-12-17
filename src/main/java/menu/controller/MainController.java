package menu.controller;

import menu.constant.Category;
import menu.constant.Day;
import menu.model.Recommender;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    List<Category> categories;
    Recommender recommender;

    public MainController(){
        categories = new ArrayList<>();
        recommender = new Recommender();
    }

    public void execute(){
        OutputView.printServiceStartMessage();
        OutputView.printGetCoachNamesMessage();
        String[] coachNames = InputView.readCoachNames();

    }

    private void setCategories(){
        for(int i = 0; i < Day.size(); i++){
            setCategoryOfDay(Day.get(i));
        }
    }

    private void setCategoryOfDay(Day day){
        Category recommendedCategory = recommender.recommendCategory();
        if(checkDuplicationCount(recommendedCategory) >= 2){
            setCategoryOfDay(day);
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
}
