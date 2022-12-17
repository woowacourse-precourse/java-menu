package menu.model;

import java.util.HashSet;
import java.util.List;

public class Coach {
    private String name;
    private HashSet<String> allergy;
    private List<String> recommendation;

    public Coach(String name, HashSet<String> allergy, List<String> recommendation) {
        this.name = name;
        this.allergy = allergy;
        this.recommendation = recommendation;
    }

    public String getName() {
        return name;
    }

    public List<String> getRecommendation() {
        return recommendation;
    }

    public void addAllergy(String allegeMenu) {
        allergy.add(allegeMenu);
    }

    public boolean checkAllegeMenu(String menuName) {
        return allergy.contains(menuName);
    }

    public void addRecommendation(String recommendation) {
        this.recommendation.add(recommendation);
    }
}
