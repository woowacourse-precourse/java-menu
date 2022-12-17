package menu.service;

import menu.domain.Ban;
import menu.domain.Coach;
import menu.view.OutputView;

public class BanService {
    public Ban initializeBan(Coach coach) {
        for (String name : coach.getCoachNames()) {
            OutputView.messageBanInput(name);
        }
        return null;
    }
}
