package menu.model.validate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2022. 12. 17.
 */
class InputVerifierTest {

    @DisplayName("코치의 이름이 2글자 이상 4글자 이하인가")
    @Test
    void 코치이름이_2글자_이상_4글자_이하() {
        // given
        String coachName = "토미미미미";

        // when, then
        assertThrows(IllegalArgumentException.class, () -> {
            InputVerifier.coachNameIsMin2Max4(coachName);
        });
    }

    @DisplayName("밥을 함께 먹는 코치의 수가 2~5명인가")
    @Test
    void 같이_밥_먹는_코치_수가_최소2명_최대5명() {
        // given
        int coachCount = 6;

        // when, then
        assertThrows(IllegalArgumentException.class, () -> {
            InputVerifier.coachesCountMin2Max5(coachCount);
        });
    }

}