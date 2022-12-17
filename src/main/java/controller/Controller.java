package controller;

import service.Service;
import view.InputView;
import view.OutputView;
import view.ViewRenderer;

public class Controller {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    ViewRenderer viewRenderer = new ViewRenderer();
    Service service = new Service();

    public void control() {
        init();
        recommend();
        end();
    }

    private void init() {
        outputView.printStartMessage();
        while (true) {
            try {
                service.saveCoachNames(inputView.readCoachNames());
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
        while (service.isOnInitializing()) {
            service.saveInedibleMenu(service.getCoachName(), inputView.readInedibleMenu(service.getCoachName()));
        }
    }

    private void recommend() {
        service.chooseCategories();
        service.chooseMenus();
        outputView.printRecommendation(viewRenderer.render(service.getRecommendation()));
    }

    private void end() {
        outputView.printEndMessage();
    }
}
