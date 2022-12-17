package menu;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

public class CoachTest {
    Coach coach = new Coach();

    @Test
    void 코치_수_예외() {
        String input = "구구";
        String errorMessage = "[ERROR] 코치의 수는 2-5명입니다.";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> coach.getNames());
        assertThat(e.getMessage()).isEqualTo(errorMessage);

        input = "구구,제임스,와이파이,안내,사항,방법";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        e = assertThrows(IllegalArgumentException.class,
                () -> coach.getNames());
        assertThat(e.getMessage()).isEqualTo(errorMessage);
    }

    @Test
    void 코치_이름_길이_예외() {
        String input = "구구,제임스제임스";
        String errorMessage = "[ERROR] 코치의 이름의 길이는 2-4글자 입니다.";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> coach.getNames());
        assertThat(e.getMessage()).isEqualTo(errorMessage);

        input = "구구,제";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        e = assertThrows(IllegalArgumentException.class,
                () -> coach.getNames());
        assertThat(e.getMessage()).isEqualTo(errorMessage);
    }
}
