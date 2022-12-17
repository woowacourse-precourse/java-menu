package menu.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;
import java.util.Arrays;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputViewTest {

    // 사용자 입력
    static void putSystemInput(String input) {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    /**
     * setCoachesName
     */
    @DisplayName("코치 이름 입력")
    @ValueSource(strings = {"므악", "와악,느악", "가가,나나,다다,라라,마마", "AB", "AA,BB"})
    @ParameterizedTest
    void setCoachesName_테스트(String coachesName_input) {
        putSystemInput(coachesName_input);
        String[] coachesName = coachesName_input.split(",");
        assertThat(Arrays.asList(coachesName)).containsExactlyElementsOf(Arrays.asList(InputView.setCoachesName()));
    }

    @DisplayName("코치 이름 입력에 대한 예외처리")
    @ValueSource(strings = {"A", "", " ", "앍", "가가,나나,다다,라라,마마,바바"})
    @ParameterizedTest
    void setCoachesName_예외테스트(String coachesName_input) {
        putSystemInput(coachesName_input);
        assertSimpleTest(() ->
                assertThatThrownBy(InputView::setCoachesName)
                        .isInstanceOf(IllegalArgumentException.class));
    }

}
