package menu.controller;

import menu.domain.Coach;
import menu.domain.CoachRepository;
import menu.inputview.CoachInfoInputView;
import menu.outputview.CoachInfoOutputView;

import java.util.List;

public class CoachInfoController extends AbstractController {
    @Override
    public void doProcess() {
        List<Coach> coaches = getCoaches();
        CoachRepository.saveAll(coaches);
    }

    private static List<Coach> getCoaches() {
        CoachInfoOutputView.printAskingCoachNames();
        return CoachInfoInputView.getCoaches();
    }
}
