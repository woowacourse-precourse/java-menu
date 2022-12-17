package menu.view;

import java.util.List;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Menu;

public interface InputView {

    Coaches sendCoachNames();

    List<Menu> sendHateMenuBySpecificCoach(Coach coach);
}
