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
    private CategoryAndFood categoryAndFood;
    private List<Coach> coachList;
    private List<String> recommandatedCategory;

    public Recommander() {
        this.categoryGenerator = new CategoryGenerator();
        this.categoryAndFood = new CategoryAndFood();
        this.database = categoryAndFood.getDataBase();
        this.coachList = new ArrayList<>();
        this.recommandatedCategory = new ArrayList<>();
    }

    public void run() {
        OutputView.getInvitation();
        getCoaches();
        getAllergy();
        for (int i = 0; i < 5; i++) {
            String generatedCategory = categoryGenerator.generateCategory();
            recommandatedCategory.add(generatedCategory);
            setCategory(generatedCategory);
            recommand(generatedCategory);
        }
        OutputView.printResult();
        OutputView.printCategory("카테고리", recommandatedCategory);
        printCoaches();
        OutputView.printEnd();
    }

    private void getCoaches() {
        try {
            List<String> coachName = InputView.getCoachList();
            for (String name :
                    coachName) {
                Coach coach = new Coach(name, this.database);
                coachList.add(coach);
            }
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            getCoaches();
        }
    }

    private void getAllergy() {

        for (Coach coach :
                coachList) {
            OutputView.getAllergic(coach.name);
            try {
                coach.setAllergic(InputView.getAllergy());
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
                getCoaches();
            }
        }
    }

    private void printCoaches() {
        for (Coach coach :
                coachList) {
            coach.out();
        }
    }

    private void setCategory(String category) {
        for (Coach coach :
                coachList) {
            coach.setCategory(category);
        }
    }

    private void recommand(String category) {
        for (Coach coach :
                coachList) {
            coach.recommandMenu(category);
        }
    }

}
