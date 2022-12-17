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
    void methodName() {
        // given
        String coachName = "토미미미미";

        // when, then
        assertThrows(IllegalArgumentException.class, () -> {
            InputVerifier.coachNameIsMin2Max4(coachName);
        });
    }

}