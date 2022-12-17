package menu.views;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

class UserInputTest {

    private final UserInput userInput = new UserInput();
    private static final String ERROR_MESSAGE= "[ERROR]";

    OutputStream out;
    InputStream in;

    void beforeSetting(String input){
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    void getExceptionTest(Supplier<?> testFunction){
        try{
            testFunction.get();
        }catch(NoSuchElementException ignored){}
        assertThat(out.toString().trim()).contains(ERROR_MESSAGE);
    }

    @Nested
    class RequestCoachNameTest{

        void getRequestCoachNameTest(String input){
            beforeSetting(input);
            List<String> output = Arrays.asList(input.split(","));
            assertThat(userInput.requestCoachName()).isEqualTo(output);
        }

        @DisplayName("통합 테스트 - 정상적으로 코치님 세 분 입력 시 원하는 값 출력")
        @Test
        void requestCoachName_case1() {
            String input = "토미,제임스,포코";
            getRequestCoachNameTest(input);
        }

        @DisplayName("통합 테스트 - 정상적으로 코치님 두 분 입력 시 원하는 값 출력")
        @Test
        void requestCoachName_case2() {
            String input = "토미,제임스";
            getRequestCoachNameTest(input);
        }

        @DisplayName("통합 테스트 - 정상적으로 코치님 네 분 입력 시 원하는 값 출력")
        @Test
        void requestCoachName_case3() {
            String input = "토미,제임스,포코,포비";
            getRequestCoachNameTest(input);
        }

        @DisplayName("통합 테스트 - 정상적으로 코치님 한 분 입력 시 exception 발생")
        @Test
        void requestCoachName_exception1() {
            String input = "토미";
            beforeSetting(input);
            Supplier<List<String>> functionSupply = userInput::requestCoachName;
            getExceptionTest(functionSupply);
        }
    }


    @Nested
    class RequestCannotEatMenuTest{

        void getRequestCannotEatMenuTest(String input){
            beforeSetting(input);
            List<String> output = Arrays.asList(input.split(","));
            assertThat(userInput.requestCannotEatMenu()).isEqualTo(output);
        }

        @DisplayName("통합 테스트 - 정상적으로 메뉴 한 개 입력시 통과")
        @Test
        void requestCannotEatMenu_case1() {
            String input = "라자냐";
            getRequestCannotEatMenuTest(input);
        }

        @DisplayName("통합 테스트 - 정상적으로 메뉴 두 개 입력시 통과")
        @Test
        void requestCannotEatMenu_case2() {
            String input = "라자냐,스시";
            getRequestCannotEatMenuTest(input);
        }

        @DisplayName("통합 테스트 - 메뉴를 입력하지 않을 시 통과")
        @Test
        void requestCannotEatMenu_case3() {
            String input = "";
            beforeSetting(input);
            assertThat(userInput.requestCannotEatMenu()).isNull();
        }

        @DisplayName("통합 테스트 - 메뉴를 3개 입력할 시 exception 발생")
        @Test
        void requestCannotEatMenu_exception1() {
            String input = "라자냐,스시,탕수육";
            beforeSetting(input);
            Supplier<List<String>> functionSupply = userInput::requestCannotEatMenu;
            getExceptionTest(functionSupply);
        }
    }

}