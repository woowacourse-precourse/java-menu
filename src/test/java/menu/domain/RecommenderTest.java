package menu.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

class RecommenderTest {

    @Test
    void 코치는_2_이상_5이하_명이다() {
        assertThatNoException().isThrownBy(() -> new Recommender(createCoaches(2)));
    }

    @Test
    void 코치가_너무_적으면_예외를_던진다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Recommender(createCoaches(1)));
    }

    @Test
    void 코치가_너무_많으면_예외를_던진다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Recommender(createCoaches(6)));
    }

    private List<Coach> createCoaches(int number) {
        Supplier<Coach> coachSupplier = () -> new Coach("이름", List.of());
        List<Coach> coaches = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            coaches.add(coachSupplier.get());
        }
        return coaches;
    }

}