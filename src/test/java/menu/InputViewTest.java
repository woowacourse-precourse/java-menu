package menu;

import menu.View.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
    private final InputView inputView = new InputView();

    @DisplayName("코치 이름의 입력이 정상인 경우")
    @Test
    void goodCoachNames() {
        List<String> names = inputView.parseCoachName("토미,제임스,포코");
        assertThat(names).containsOnly("토미","제임스","포코");
    }

    @DisplayName("코치의 수가 잘못된 경우")
    @Test
    void wrongNumCoachNames() {
        assertThatThrownBy(() -> inputView.parseCoachName("토미"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> inputView.parseCoachName("토미,제임스,포코,해리,스네이프,시리우스"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("코치 이름의 길이가 잘못된 경우")
    @Test
    void wrongLengthCoachNames() {
        assertThatThrownBy(() -> inputView.parseCoachName("토미,제임스,헤르미온느"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> inputView.parseCoachName("토미,제임스,론"))
                .isInstanceOf(IllegalArgumentException.class);
    }






}
