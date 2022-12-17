package menu.domain;

import menu.utils.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CoachGroupTest {

    @Test
    void CouchGroup_객체가_중복된_이름의_Couch를_가지면_예외() {
        List<Coach> coaches = List.of(
                Coach.from("최준호"),
                Coach.from("최준호"),
                Coach.from("김준호"));

        Assertions.assertThatThrownBy(() -> CoachGroup.from(coaches))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.COACH_NAME_DUPLICATE.getMessage());
    }

    @Test
    void Couch가_2명에서_5명사이가_아니면_예외() {
        List<Coach> coaches = List.of(Coach.from("최준호"),
                Coach.from("박준호"),
                Coach.from("이준호"),
                Coach.from("성준호"),
                Coach.from("나준호"),
                Coach.from("김준호"));
        Assertions.assertThatThrownBy(() -> CoachGroup.from(coaches))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.COACH_GROUP_OUT_OF_RANGE.getMessage());
    }

    @Test
    void 인자로_주어진_Couch와_size가_동일하다() {
        List<Coach> coaches = List.of(Coach.from("최준호"),
                Coach.from("박준호"),
                Coach.from("성준호"),
                Coach.from("김준호"));

        CoachGroup group = CoachGroup.from(coaches);
        Assertions.assertThat(group.size()).isEqualTo(coaches.size());
    }
}