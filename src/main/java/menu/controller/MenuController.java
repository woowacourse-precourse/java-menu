package menu.controller;

import menu.domain.Coach;
import menu.domain.Menu;
import menu.service.CoachService;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class MenuController extends Controller{

    private final CoachService coachService = new CoachService();

    public MenuController(InputView inputView, OutputView outputView) {
        super(inputView, outputView);
    }


    @Override
    public void run() {
        start();
        generateCoachList();
        repeat(this::inputHateMenus);

    }

    public void start() {
        outputView.printStartMessage();
    }

    public void generateCoachList() {
        List<Coach> coaches = repeat(inputView::readCoaches);

    }

    public List<Coach> inputHateMenus() {
        List<Coach> coaches = coachService.findAll();
        coaches.forEach(coach -> {
            List<Menu> hateMenus = inputView.readHateMenus(coach.getName());
            coachService.inputHateMenus(coach, hateMenus);
        });

        return coaches;
    }

}
