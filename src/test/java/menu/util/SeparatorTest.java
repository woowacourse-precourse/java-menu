package menu.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2022. 12. 17.
 */
class SeparatorTest {

    @DisplayName("쉼표를 기준으로 분리가 잘 되는가")
    @Test
    void 문자열_분리() {
        // given
        String input = "토미,제임스,포코";

        // when
        List<String> results = Separator.separateCoachInfo(input);

        // then
        assertEquals(results.size(), 3);
    }
}