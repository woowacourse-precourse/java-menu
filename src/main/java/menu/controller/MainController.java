package menu.controller;

import menu.domain.Coach;
import menu.domain.CoachRepository;
import menu.view.InputView;
import menu.view.OutputView;
import menu.domain.RecommendRepository;

import java.util.function.Supplier;

public class MainController {
    private final RecommendRepository recommendRepository;
    private final CoachRepository coachRepository;
    private final InputView inputView;
    private final OutputView outputView;

    public MainController() {
        this.recommendRepository = new RecommendRepository();
        this.coachRepository = new CoachRepository();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        outputView.printStart();
        createCoach();
        recommendRepository.recommendStart(coachRepository);
        finish();
    }

    private void createCoach() {
        outputView.printCoachNameRequest();
        coachRepository.generateCoaches(repeat(inputView::inputNameOfCoaches));

        for (Coach coach : coachRepository.getCoaches()) {
            coach.setHateFood(repeat(() -> inputView.inputHateFood(coach)));
        }
    }

    private void finish() {
        outputView.printResult();
        outputView.printWeek();
        outputView.printCategory(recommendRepository.getCategories());
        outputView.printCoach(coachRepository.getCoaches());
        outputView.printEnd();
    }

    private <T> T repeat(Supplier<T> reader) {
        try {
            return reader.get();
        } catch(IllegalArgumentException exception) {
            outputView.printError(exception);
            return repeat(reader);
        }
    }
}
