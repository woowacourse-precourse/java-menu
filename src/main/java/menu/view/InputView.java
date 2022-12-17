package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.Coach;
import menu.domain.CoachRepository;
import menu.domain.DislikeMenuRepository;

public class InputView implements Input {
    @Override
    public CoachRepository getCoach() {
        System.out.println(System.lineSeparator() + "코치의 이름을 입력해 주세요. (, 로 구분)");
        try {
            return new CoachRepository(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCoach();
        }
    }

    @Override
    public DislikeMenuRepository getDislikeFood(CoachRepository coachRepository) {
        DislikeMenuRepository dislikeMenus = new DislikeMenuRepository();
        for (Coach coach : coachRepository.coaches()) {
            validateFood(dislikeMenus, coach);
        }
        return dislikeMenus;
    }

    private void validateFood(DislikeMenuRepository dislikeMenus, Coach coach) {
        try {
            System.out.println(System.lineSeparator() + coach.name() + "(이)가 못 먹는 메뉴를 입력해 주세요.");
            dislikeMenus.add(Console.readLine(), coach);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            validateFood(dislikeMenus, coach);
        }
    }
}
