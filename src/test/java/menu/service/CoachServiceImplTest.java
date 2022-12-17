package menu.service;

import menu.domain.Coach;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CoachServiceImplTest {

    private static final Integer COACH_LIST_LENGTH = 10;

    @Test
    void 코치목록조회() {
        // given
        List<Coach> coaches = constructorCoaches();
        final CoachServiceImpl coachServiceImpl = new CoachServiceImpl(coaches);

        // when

        // then
        Assertions.assertThat(coachServiceImpl.getCoaches().size()).isEqualTo(COACH_LIST_LENGTH);
    }

    @Test
    void 없는코치에거절메뉴추가() {
        // given
        List<Coach> coaches = constructorCoaches();
        final CoachServiceImpl coachServiceImpl = new CoachServiceImpl(coaches);
        Coach coach = new Coach("test");
        List<String> refuseMenus = new ArrayList<>();

        // when
        coachServiceImpl.addRefuseMenuToCoach(coach, refuseMenus);
        // then
    }

    private List<Coach> constructorCoaches() {
        List<Coach> coaches = new ArrayList<>();
        for (int i=0; i<COACH_LIST_LENGTH; i++) {
            Coach coach = new Coach(String.valueOf(i));
            coaches.add(coach);
        }
        return coaches;
    }
}
