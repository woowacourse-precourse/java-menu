package menu;

import menu.Domain.CategoryGenerator;
import menu.Domain.Coach;
import menu.Util.CategoryAndFood;
import menu.Util.InputView;
import menu.Util.OutputView;
import menu.Util.SystemMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Recommander {
    private CategoryGenerator categoryGenerator;
    private HashMap<String, List<String>> database;
    private CategoryAndFood categoryAndFood;
    private List<Coach> coachList;
    private List<String> recommandatedCategory;
    private static final int dayCount = 5;

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
        for (int i = 0; i < dayCount; i++) {
            String generatedCategory = categoryGenerator.generateCategory();
            recommandatedCategory.add(generatedCategory);
            setCategory(generatedCategory);
            recommand(generatedCategory);
        }
        OutputView.printResult();
        OutputView.printCategory(SystemMessage.Category.getMessage(), recommandatedCategory);
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
            setAllegyByCoach(coach);
        }
    }

    private void setAllegyByCoach(Coach coach) {
        try {
            OutputView.getAllergic(coach.name);
            coach.setAllergic(InputView.getAllergy());
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            setAllegyByCoach(coach);
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
