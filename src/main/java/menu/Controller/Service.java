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

    private Coachs getCoachsUntilValid() {
        while (true) {
            try {
                return this.input.readCoachNames();
            } catch (Exception e) {
                this.output.printError(e.getMessage());
            }
        }
    }

    private void setInedibleUntilValid(Coach coach) {
        boolean isValid = false;
        while (!isValid) {
            try {
                coach.setInedible(this.input.readInedibles(coach));
                isValid = true;
            } catch (Exception e) {
                this.output.printError(e.getMessage());
                isValid = false;
            }
        }
    }

    private void setCoachsInedible() {
        for (Coach coach : this.coachs.getCoachs()) {
            setInedibleUntilValid(coach);
        }
    }

    public void makeRecommendations() {
        recommend.makeRecommendations(this.coachs);
    }

    public void endService() {
        this.output.printResult(this.coachs, recommend.getPickCategories());
        this.output.printEnd();
    }

}
