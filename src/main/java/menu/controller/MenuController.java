package menu.controller;

import menu.domain.Coachs;
import menu.view.InputView;

public class MenuController {

    private Coachs inputCoachNames(){
        return Coachs.from(InputView.inputCoachNames());
    }
}
