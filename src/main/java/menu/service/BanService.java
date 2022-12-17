package menu.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import menu.domain.Ban;
import menu.domain.Coach;
import menu.view.InputView;
import menu.view.OutputView;

public class BanService {
    public Ban initializeBan(Coach coach) {
        Map<String, ArrayList<String>> banResults = new HashMap<>();
        for (String coachName : coach.getCoachNames()) {
            OutputView.messageBanInput(coachName);
            banResults.put(coachName, (ArrayList<String>) InputView.readBanMenu());
        }
        return new Ban(banResults);
    }
}
