package menu.model.service;

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

    // 에러 발생시 그 시점부터 재시작해야하는데 재귀성 문제 해결해야함.
    public List<String> getCoaches() {
        String coaches = InputView.getCoaches();
        List<String> coachesName = Separator.separateCoachName(coaches);
        for (String coachName : coachesName) {
            if (!InputVerifier.tryCoachesCountMin2Max5(coachesName)) {
                getCoaches();
            }
            if (!InputVerifier.tryCoachNameIsMin2Max4(coachName)) {
                getCoaches();
            }
        }
        return coachesName;
    }

}
