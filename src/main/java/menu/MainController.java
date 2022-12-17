package menu;


import menu.dto.SuggestMenuResultDto;
import menu.repository.CoachRepository;
import menu.service.SuggestMenuService;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class MainController {

    public static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();

    private final CoachRepository coachRepository;
    private final SuggestMenuService suggestMenuService;

    private static final MainController instance = new MainController();

    private MainController() {
        coachRepository = CoachRepository.getInstance();
        suggestMenuService = SuggestMenuService.getInstance();
    }

    public static MainController getInstance() {
        return instance;
    }

    public void run() {
        readCoachInfo();
        suggestMenu();
    }

    public void readCoachInfo() {
        while (true) {
            try {
                List<Coach> coaches = inputView.readCoach();
                for (Coach coach : coaches) {
                    List<String> hateMenu = inputView.readHateMenu(coach);
                    coach.addHateMenus(hateMenu);
                    coachRepository.save(coach);
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_MESSAGE_PREFIX + e.getMessage());
            }
        }
    }

    public void suggestMenu() {
        while (true) {
            try {
                SuggestMenuResultDto suggestMenuResultDto = suggestMenuService.suggest();
                outputView.printResult(suggestMenuResultDto);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_MESSAGE_PREFIX + e.getMessage());
            }
        }
    }
}
