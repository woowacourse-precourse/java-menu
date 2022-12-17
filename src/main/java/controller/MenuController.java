package controller;

import menu.Coach;
import repository.CoachRepository;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class MenuController {
    private static final int MINIMUM_COACHES = 2;
    private final OutputView outputView;
    private final InputView inputView;

    public MenuController(OutputView outputView) {
        this.outputView = outputView;
        this.inputView = new InputView(outputView);
    }

    public void run() {
        outputView.printStartMessage();
        makeCoaches(inputView.readCoachNames());

    }

    private void makeCoaches(String coachNames) {
        try {
            List<String> names = splitCoaches(coachNames);
            List<Coach> coaches = makeCoaches(names);
            CoachRepository.initializeCoaches(coaches);
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
            makeCoaches(inputView.readCoachNames());
        }
    }

    private List<Coach> makeCoaches(List<String> coachNames) {
        return coachNames.stream().map(name -> new Coach(name))
                .collect(Collectors.toList());
    }

    private List<String> splitCoaches(String coachNames) {
        List<String> names = List.of(coachNames.split(","));
        if (names.size() < MINIMUM_COACHES) {
            throw new IllegalArgumentException("코치는 최소 2명 이상 입력해야 합니다.");
        }
        return names;
    }
}
