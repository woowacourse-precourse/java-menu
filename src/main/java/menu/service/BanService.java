package menu.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.domain.Ban;
import menu.domain.Coach;
import menu.view.InputView;
import menu.view.OutputView;

public class BanService {
    public Ban initializeBan(Coach coach) {
        Map<String, ArrayList<String>> banResults = new HashMap<>();
        for (String coachName : coach.getCoachNames()) {
            banResults.put(coachName, (ArrayList<String>) getBanMenu(coachName));
        }
        return new Ban(banResults);
    }

    private List<String> getBanMenu(String coachName) {
        while (true) {
            try {
                OutputView.messageBanInput(coachName);
                return InputView.readBanMenu();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
