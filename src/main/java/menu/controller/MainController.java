package menu.controller;

import menu.domain.Coach;
import menu.domain.CoachRepository;
import menu.domain.NoEatMenu;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MainController extends AbstractController {

    private final InputView inputView;
    private final OutputView outputView;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    void doProcess() {
        outputView.printFeatures();
        CoachRepository coachRepository = makeCoachRepository();
        NoEatMenu noEatMenu = askAboutFoodCoachNoEat(coachRepository);

    }

    private NoEatMenu askAboutFoodCoachNoEat(CoachRepository coachRepository) {
        HashMap<Coach, List<String>> noEatMenuHash = new HashMap<>();
        for (Coach coach : coachRepository.getCoachList()) {
            outputView.printCantEatMenu(coach.getName());
            String[] strings = inputView.readNoEatMenu();
            noEatMenuHash.put(coach, Arrays.asList(strings));
        }
        return new NoEatMenu(noEatMenuHash);
    }

    private CoachRepository makeCoachRepository() {
        List<Coach> coachList = new ArrayList<>();
        for (String coachName : inputView.readCoachNames()) {
            coachList.add(new Coach(coachName));
        }
        return new CoachRepository(coachList);
    }
}
