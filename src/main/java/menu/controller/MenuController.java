package menu.controller;

import menu.domain.Coach;
import menu.domain.Coachs;
import menu.view.InputView;

public class MenuController {

    private Coachs inputCoachNames(){
        return Coachs.from(InputView.inputCoachNames());
    }

    private void inputCoachInedibles(Coachs coachs){
        for(Coach coach : coachs.getCoachs()){
            coach.addInedibles(InputView.inputCoachInedibles(coach.getName()));
        }
    }
}
