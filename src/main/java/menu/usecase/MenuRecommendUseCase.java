package menu.usecase;

import menu.domain.Group;

public interface MenuRecommendUseCase {

    /**
     * 설정된 요일별 카테고리에 따라 메뉴 추천
     */
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
