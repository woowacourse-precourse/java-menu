package menu;

import java.util.List;

public class Recommender {

    private final List<Coach> coaches;

    public Recommender(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public void recommend() {
        for (int i = 0; i < 5; i++) {
            for (Coach coach : coaches) {
                coach.getRecommended();
            }
        }
    }
}
