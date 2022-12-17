package menu.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class InputViewTest {
    @Nested
    @DisplayName("힝")
    class MenuInputTest extends NsTest {

        List<String> result;

        @Test
        @DisplayName("빈문자열 입력시 어떻게..")
        public void emptyString() {
            run("\n");
            System.out.println(result);
            for(String r : result) {
                System.out.printf("[%s] ", r);
            }
        }

        @Override
        protected void runMain() {
            result = InputView.readMenuCoachCannotEat("가용");
        }
    }
}