package menu.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoachesTest {

    @Test
    @DisplayName("코치 식사 인원은 2~5명 이내만 허용")
    void UNDER_2(){
        String[] coaches = {"포비"};
        Assertions.assertThatThrownBy(
            () -> new Coaches(List.of(coaches))
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("코치 식사 인원은 2~5명 이내만 허용")
    void OVER_5(){
        String[] coaches = {"포비","크롱","뿌우","디노","한마바키","루피"};
        Assertions.assertThatThrownBy(
            () -> new Coaches(List.of(coaches))
        ).isInstanceOf(IllegalArgumentException.class);
    }


}