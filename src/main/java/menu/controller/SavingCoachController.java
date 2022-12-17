package menu.controller;

import menu.controller.system.AbstractController;
import menu.domain.Coach;
import menu.domain.CoachRepository;
import menu.inputview.CoachInfoInputView;
import menu.outputview.CoachInfoOutputView;

import java.util.List;
import java.util.Map;

public class SavingCoachController extends AbstractController {
    @Override
    public void doProcess(Map<String, Object> model) {
        List<Coach> coaches = getCoaches();
        CoachRepository.saveAll(coaches);
    }



    private static List<Coach> getCoaches() {
        CoachInfoOutputView.printAskingCoachNames();
        return CoachInfoInputView.getCoaches();
    }
}
