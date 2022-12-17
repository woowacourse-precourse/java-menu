package menu.domain;

import menu.repository.CoachRepository;
import menu.repository.MenusRepository;

public class MenuSelector {

    CoachRepository coachRepository = new CoachRepository();

    public void selectCategories(Coaches coaches) {
        coachRepository.setCoach(coaches);
        for (int i = 0; i < Weekday.values().length; i++) {
            Category category = Category.randomCategory();
            addCoachMenu(coaches, category);
        }
    }

    private void addCoachMenu(Coaches coaches, Category category) {
        for (Coach coach : coaches.getCoaches()) {
            coachRepository.put(coach, MenusRepository.getRandomMenuByCategory(category));
        }
    }


}
