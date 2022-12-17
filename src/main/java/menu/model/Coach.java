package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private String name;
    private List<String> notEat;
    private List<String> alreadyRecommended = new ArrayList<>();

    public Coach(String name, List<String> notEat) {
        this.name = name;
        this.notEat = new ArrayList<>(notEat);
    }

    public void printCoach() { // TODO
        System.out.println(name + alreadyRecommended);
    }

    public List<String> getAlreadyRecommended() {
        return alreadyRecommended;
    }

    public String getName() {
        return name;
    }

    public void addFood(String recommendedFood) {
        alreadyRecommended.add(recommendedFood);
    }

    public boolean isAlreadyRecommended(String recommendedFood) {
        return alreadyRecommended.contains(recommendedFood);
    }

    public boolean isNotEat(String recommendedFood) {
        return notEat.contains(recommendedFood);
    }
}
