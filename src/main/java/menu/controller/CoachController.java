package menu.controller;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import menu.controller.exception.NotFoundCoachControllerLogicException;
import menu.controller.status.CoachControllerStatus;
import menu.service.coach.CoachService;
import menu.view.coach.CoachInputView;
import menu.view.coach.CoachOutputView;

public class CoachController {

    private final CoachService coachService;
    private final CoachInputView inputView;
    private final CoachOutputView outputView;

    public CoachController(CoachService coachService, CoachInputView inputView, CoachOutputView outputView) {
        this.coachService = coachService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    private enum CoachControllerMappings {
        ADD_COACHES(CoachControllerStatus.INPUT_COACHES_NAME,
                CoachController::addCoaches),
        ADD_COACH_NOT_EAT_MENUS(CoachControllerStatus.INPUT_COACHES_NOT_EAT_MENUS_NAME,
                CoachController::addCoachesNotEatMenus);

        private final CoachControllerStatus status;
        private final Function<CoachController, CoachControllerStatus> handler;

        CoachControllerMappings(CoachControllerStatus status,
                Function<CoachController, CoachControllerStatus> handler) {
            this.status = status;
            this.handler = handler;
        }

        public static CoachControllerStatus handle(CoachController controller, CoachControllerStatus status) {
            return Arrays.stream(CoachControllerMappings.values())
                    .filter(mappings -> mappings.status.matches(status))
                    .map(mappings -> mappings.handler.apply(controller))
                    .findAny()
                    .orElseThrow(NotFoundCoachControllerLogicException::new);
        }
    }

    public CoachControllerStatus process(CoachControllerStatus status) {
        try {
            return CoachControllerMappings.handle(this, status);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return status;
        }
    }

    private CoachControllerStatus addCoaches() {
        String coachesName = inputView.readCoachesName();

        coachService.addCoaches(coachesName);
        return CoachControllerStatus.INPUT_COACHES_NOT_EAT_MENUS_NAME;
    }

    private CoachControllerStatus addCoachesNotEatMenus() {
        List<String> coachesName = coachService.findCoachesNameAll();

        coachesName.forEach(coachName -> {
            String notEatMenusName = inputView.readCoachesNotEatMenusName(coachName);
            coachService.addInedibleMenuByCoachName(coachName, notEatMenusName);
        });
        return CoachControllerStatus.EXIT;
    }
}
