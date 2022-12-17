package menu.usecase;

import menu.domain.Group;

public interface MenuRecommendUseCase {

    void command(final Command command);

    class Command {
        private final Group group;

        public Command(final Group group) {
            this.group = group;
        }

        public Group group() {
            return group;
        }
    }
}
