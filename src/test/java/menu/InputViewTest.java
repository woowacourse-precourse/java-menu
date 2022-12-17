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

    @DisplayName("싫어하는 메뉴의 입력이 정상인 경우")
    @Test
    void goodHateMenus() {
        List<String> names = inputView.parseHateMenus("우동,스시");
        assertThat(names).containsOnly("우동","스시");

        names = inputView.parseHateMenus("우동");
        assertThat(names).containsOnly("우동");

        names = inputView.parseHateMenus("");
        assertThat(names).containsOnly("");
    }

    @DisplayName("싫어하는 메뉴의 수가 잘못된 경우")
    @Test
    void wrongNumHateMenus() {
        assertThatThrownBy(() -> inputView.parseHateMenus("우동,스시,뇨끼,월남쌈"))
                .isInstanceOf(IllegalArgumentException.class);
    }





}
