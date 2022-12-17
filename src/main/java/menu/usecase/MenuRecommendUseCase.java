package menu.usecase;

import menu.domain.Coach;
import menu.domain.WeekRecommends;

import java.util.List;

public interface MenuRecommendUseCase {

    List<WeekRecommends> command(Command command);

    class Command {
        private final List<Coach> coaches;

        public Command(List<Coach> coaches) {
            this.coaches = coaches;
        }

        public List<Coach> coaches() {
            return coaches;
        }
    }
}
