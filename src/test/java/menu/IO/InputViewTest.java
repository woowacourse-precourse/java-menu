package menu.IO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    private InputView inputView;

    private InputStream inputStream;

    @BeforeEach
    void init() {
        inputView = new InputView();
    }

    void inputStreamInit(String input) {
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }

    @DisplayName("코치 이름 3명 정상입력")
    @Test
    void 코치_이름_3명_정상입력() {
        final String input = "토미,제임스,포코";
        final int expectCoachNum = 3;
        inputStreamInit(input);

        assertThat(inputView.readCoachNames().size()).isEqualTo(expectCoachNum);
    }

    @DisplayName("코치 이름 3명 이름 길이 오류입력")
    @Test
    void 코치_이름_3명_오류입력() {
        final String input = "토미,제임스제임스,포코";
        inputStreamInit(input);

        assertThatThrownBy(() -> inputView.readCoachNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("코치 이름 3명 이름 길이 오류입력후 정상 입력")
    @Test
    void 코치_이름_3명_오류입력후_정상입력() {
        final String input = "토미,제임스제임스,포코";
        inputStreamInit(input);

        assertThatThrownBy(() -> inputView.readCoachNames())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");

        final String inputCorrect = "토미,제임스,포코";
        inputStreamInit(inputCorrect);
        assertThat(inputView.readCoachNames().size()).isEqualTo(3);
    }

    @DisplayName("메뉴 이름 정상입력")
    @Test
    void 메뉴_이름_정상입력() {
        final String input = "뇨끼,월남쌈력";
        final int expectCoachNum = 2;
        inputStreamInit(input);

        assertThat(inputView.readCoachDontEatMenus().size()).isEqualTo(expectCoachNum);
    }

    @DisplayName("메뉴 이름 3개입력으로 오류입력")
    @Test
    void 메뉴_3개입력으로_오류() {
        final String input = "뇨끼,월남쌈,마파두부";
        inputStreamInit(input);

        assertThatThrownBy(() -> inputView.readCoachDontEatMenus())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("메뉴 이름 3개입력으로 오류입력")
    @Test
    void 메뉴_3개입력으로_오류후정상입력() {
        final String input = "뇨끼,월남쌈,마파두부";
        inputStreamInit(input);
        assertThatThrownBy(() -> inputView.readCoachDontEatMenus())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");

        String inputCorrect = "뇨끼,월남쌈";
        inputStreamInit(inputCorrect);
        assertThat(inputView.readCoachDontEatMenus().size()).isEqualTo(2);
    }
}