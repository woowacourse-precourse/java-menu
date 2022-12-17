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

    public Service() {
        this.output.printStart();
    }

    public void generateCoachs() {
        try {
            this.coachs = this.input.readCoachNames();
        } catch (Exception e) {
            this.output.printError(e.getMessage());
        }
    }

    public void setInedible() {
        try {
            for (Coach coach : this.coachs.getCoachs()) {
                coach.setInedible(this.input.readInedibles(coach));
            }
        } catch (Exception e) {
            this.output.printError(e.getMessage());
        }
    }

    public void makeRecommendations() {
        recommend.makeRecommendations(this.coachs);
    }

    public void endService() {
        this.output.printResult(this.coachs);
        this.output.printEnd();
    }

}
