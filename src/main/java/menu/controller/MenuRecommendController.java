package menu.controller;

import menu.domain.CategoryMaker;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class MenuRecommendController {
    public void run() {
        List<String> coachs = InputView.readCoachName();
        CategoryMaker categoryMaker = new CategoryMaker();
        categoryMaker.makeRandomCategories();
        OutputView.printResult();
        OutputView.printCategory(categoryMaker.getCategoriesName());
    }
    public void readAllCoachUableMenus(List<String> coachs){
        for(String coach : coachs){
            List<String> unableMenus = InputView.readUnableMenu(coach);
        }
    }

}
