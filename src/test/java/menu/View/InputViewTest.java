package menu.View;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class InputViewTest {
    @Test
    void 코치_이름_입력_테스트() {
        String input = "토미,제임스,포코";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        List<String> coachesName = new InputView().getCoachesName();
        assertThat(coachesName).isEqualTo(List.of("토미", "제임스", "포코"));
    }

    @Test
    void 못_먹는_음식_입력_테스트() {
        String input = "우동,스시";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        List<String> hateFood = new InputView().getHateFood("토미");
        assertThat(hateFood).isEqualTo(List.of("우동", "스시"));
    }
}