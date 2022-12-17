package menu.view;

import java.util.List;
import menu.domain.Coach;
import menu.dto.request.CoachNameDto;
import menu.dto.request.CoachesNameDto;
import menu.dto.request.HateMenuDto;

public interface InputView {

    CoachesNameDto sendCoachNames();

    HateMenuDto sendHateMenuBySpecificCoach(CoachNameDto coachNameDto);
}
