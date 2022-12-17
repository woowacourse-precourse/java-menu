package menu.Controller;

import menu.Model.Coach;
import menu.Model.Coachs;
import menu.View.InputView;
import menu.View.Outputview;

public class Service {
    private final InputView input = new InputView();
    private final Outputview output = new Outputview();
    private Recommend recommend = new Recommend();

    private Coachs coachs;

    public void generateCoachs() {
        this.coachs = this.input.readCoachNames();
    }

    public void setInedible() {
        for (Coach coach : this.coachs.getCoachs()) {
            coach.setInedible(this.input.readInedibles(coach));
        }
    }

    public void makeRecommendations() {
        recommend.makeRecommendations(this.coachs);
    }

}
