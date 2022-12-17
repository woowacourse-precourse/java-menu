package menu.model.service;

import menu.model.domain.Coach;
import menu.model.validate.InputVerifier;
import menu.util.Separator;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2022. 12. 17.
 */

public class CoachService {

    public List<String> getCoaches() {
        String coaches = InputView.getCoaches();
        List<String> coachesName = Separator.separateCoachInfo(coaches);
        for (String coachName : coachesName) {
            InputVerifier.coachNameIsOnlyKorean(coachName);
            InputVerifier.coachNameIsMin2Max4(coachName);
            InputVerifier.coachesCountMin2Max5(coachesName.size());
        }
        return coachesName;
    }

    public List<Coach> getHateMenus(List<String> coachesName) {
        List<Coach> result = new ArrayList<>();
        for (String coachName : coachesName) {
            String hateMenu = InputView.getCoachHateMenus(coachName);
            List<String> hateMenus = Separator.separateCoachInfo(hateMenu);
            InputVerifier.tryCoachesHateMenu(hateMenus);
            result.add(applyHateMenus(coachName, hateMenus));
        }
        return result;
    }

    private Coach applyHateMenus(String coachName, List<String> hateMenus) {
        return new Coach(coachName, hateMenus);
    }

    public void printRecommendMenu(List<Coach> coaches) {
        OutputView.printRecommendMenu(coaches);
    }
}
