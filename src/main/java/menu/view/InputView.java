package menu.view;

import java.util.List;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Menu;
import menu.dto.request.CoachNameDto;

public interface InputView {

    List<CoachNameDto> sendCoachNames();

    List<Menu> sendHateMenuBySpecificCoach(CoachNameDto coachNameDto);
}
