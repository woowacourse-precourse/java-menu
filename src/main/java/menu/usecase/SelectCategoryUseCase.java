package menu.usecase;

import menu.domain.Group;

public interface SelectCategoryUseCase {

    /**
     * 요일별 추천 음식 카테고리 선택
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
