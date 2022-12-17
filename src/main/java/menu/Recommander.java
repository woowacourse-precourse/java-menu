package menu;

import menu.Domain.CategoryGenerator;
import menu.Domain.Coach;
import menu.Util.CategoryAndFood;
import menu.Util.InputView;
import menu.Util.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Recommander {
    private CategoryGenerator categoryGenerator;
    private HashMap<String, List<String>> database;
    private List<String> category;
    private CategoryAndFood categoryAndFood;
    private int[] categoryCount;
    private List<Coach> coachList;
    private List<String> recommandatedCategory;

    public Recommander() {
        this.categoryGenerator = new CategoryGenerator();
        this.categoryAndFood = new CategoryAndFood();
        this.database = categoryAndFood.getDataBase();
        this.category = categoryAndFood.getCategoryList();
        this.categoryCount = new int[6];
        this.coachList = new ArrayList<>();
        this.recommandatedCategory = categoryGenerator.generate();
    }

    public void run() {
        OutputView.getInvitation();
        getCoaches();
        getAllergy();
        for (Coach coach:
             coachList) {
            coach.setCategory(recommandatedCategory);
            coach.recommandMenu();
        }
        OutputView.printResult();
        OutputView.printCategory("카테고리", recommandatedCategory);
        printCoaches();
        OutputView.printEnd();
    }

    private void getCoaches() {
        List<String> coachName = InputView.getCoachList();
        for (String name :
                coachName) {
            Coach coach = new Coach(name, this.database);
            coachList.add(coach);
        }
    }

    private void getAllergy(){
        for (Coach coach:
                coachList) {
            OutputView.getAllergic(coach.name);
            coach.setAllergic(InputView.getAllergy());
        }
    }

    private void printCoaches(){
        for (Coach coach:
             coachList) {
            coach.out();
        }
    }

}
