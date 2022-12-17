package menu.view;

import java.util.List;
import menu.domain.Coach;
import menu.dto.request.CoachNameDto;

public interface InputView {

    List<CoachNameDto> sendCoachNames();

    Coach sendHateMenuBySpecificCoach(CoachNameDto coachNameDto);
}
