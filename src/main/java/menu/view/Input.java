package menu.view;

import menu.domain.CoachRepository;
import menu.domain.DislikeMenuRepository;

public interface Input {

    CoachRepository getCoach();

    DislikeMenuRepository getDislikeFood(CoachRepository coachRepository);
}
