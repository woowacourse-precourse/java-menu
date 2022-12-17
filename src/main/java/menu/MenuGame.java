package menu;

import java.util.List;
import menu.ui.InputView;
import menu.ui.OutputView;

public class MenuGame {

    private List<Coach> coaches;

    public void start() {
        OutputView.printMenuGameStart();
        play();
    }

    private void play() {
        try {
            createCoaches();
        }catch(IllegalArgumentException illegalArgumentException){
            OutputView.printErrorMessage(illegalArgumentException.getMessage());
        }
    }

    private void createCoaches() {
        List<String> coachesNameOrigin;
        do{
            coachesNameOrigin = List.of((InputView.readCoachesName()).split(","));
        }while(!isValidCoachesName(coachesNameOrigin));
    }

    private boolean isValidCoachesName(List<String> coachesNameOrigin) {
        if(!isValidCoachesCount(coachesNameOrigin))
            return false;
        return true;
    }

    private boolean isValidCoachesCount(List<String> coachesNameOrigin) {
        if((coachesNameOrigin.size() >= 2) && (coachesNameOrigin.size() <= 5))
            return true;
        throw new IllegalArgumentException("[ERROR] 멤버의 수가 적절하지 않습니다. (최소 2명, 최대 5명)");
    }
}
