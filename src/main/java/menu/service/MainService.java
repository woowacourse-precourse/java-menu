package menu.service;

import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Recommender;
import menu.util.ExceptionHandler;
import java.util.List;
import java.util.stream.Collectors;

public class MainService {
    private final ExceptionHandler exceptionHandler;
    private Coaches coaches;
    private Recommender recommender;

    public MainService(ExceptionHandler exceptionHandler) {
        this.exceptionHandler = exceptionHandler;
    }

    public void generateCoaches(List<String> coachNames) {
        List<Coach> coaches = coachNames.stream()
                .map(Coach::new)
                .collect(Collectors.toList());
        this.coaches = new Coaches(coaches);
    }

    public void setHateMenus(List<String> hateMenus, String coachName) {
        Coach coach = coaches.findByName(coachName);
        coach.setHateMenus(hateMenus);
    }

    public void recommend() {
        recommender = new Recommender();
        exceptionHandler.process(coaches::recommendMenus, recommender);
    }

    public List<Category> getCategories() {
        return recommender.getCategories();
    }

    public List<Coach> getCoaches() {
        return coaches.getCoaches();
    }
}