package menu.views;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {

    private final Validator validator = new Validator();
    private static final String ERROR_MESSAGE= "[ERROR]";

    OutputStream out;

    @BeforeEach
    void beforeSetting(){
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    void getExceptionTest(Supplier<?> testFunction){
        try{
            testFunction.get();
        }catch(NoSuchElementException ignored){}
        assertThat(out.toString().trim()).contains(ERROR_MESSAGE);
    }

    @Nested
    class ValidateCoachListTest{

        @DisplayName("코치님들을 정상적으로 입력 시 통과")
        @Test
        void validateCoachList_case1() {
            String[] userInput = {"토미","제임스","포코"};
            assertThat(validator.validateCoachList(userInput)).isTrue();
        }

        @DisplayName("코치님 한 분 입력시 exception 발생")
        @Test
        void validateCoachList_exception1(){
            String[] userInput = {"토미"};
            Supplier<Boolean> functionSupply = () -> validator.validateCoachList(userInput);
            getExceptionTest(functionSupply);
        }

        @DisplayName("코치님 6분 입력 시 exception 발생")
        @Test
        void validateCoachList_exception2(){
            String[] userInput = {"토미","제임스","포코","포비","브라운","레아"};
            Supplier<Boolean> functionSupply = () -> validator.validateCoachList(userInput);
            getExceptionTest(functionSupply);
        }

        @DisplayName("코치님 입력이 공란일 때 exception 발생")
        @Test
        void validateCoachList_exception3(){
            String[] userInput = {};
            Supplier<Boolean> functionSupply = () -> validator.validateCoachList(userInput);
            getExceptionTest(functionSupply);
        }

        @DisplayName("코치님의 이름이 한 글자일 때 exception 발생")
        @Test
        void validateCoachList_exception4() {
            String[] userInput = {"톰","제임스","포코"};
            Supplier<Boolean> functionSupply = () -> validator.validateCoachList(userInput);
            getExceptionTest(functionSupply);
        }

        @DisplayName("코치님의 이름이 다섯 글자일 때 exception 발생")
        @Test
        void validateCoachList_exception5() {
            String[] userInput = {"토마스친구","제임스","포코"};
            Supplier<Boolean> functionSupply = () -> validator.validateCoachList(userInput);
            getExceptionTest(functionSupply);
        }

        @DisplayName("코치님의 이름이 여섯 글자일 때 exception 발생")
        @Test
        void validateCoachList_exception6() {
            String[] userInput = {"우아한형제들","제임스","포코"};
            Supplier<Boolean> functionSupply = () -> validator.validateCoachList(userInput);
            getExceptionTest(functionSupply);
        }
    }

    @Nested
    class ValidateNotHaveMenuTest{

        @DisplayName("올바른 못 먹는 메뉴 입력 시 통과")
        @Test
        void validateNotHaveMenuList_case1() {
            String[] userInput = {"우동","스시"};
            assertThat(validator.validateNotHaveMenuList(userInput)).isTrue();
        }

        @DisplayName("못 먹는 메뉴를 입력하지 않았을 때도 통과")
        @Test
        void validateNotHaveMenuList_case2() {
            String[] userInput = {};
            assertThat(validator.validateNotHaveMenuList(userInput)).isTrue();
        }

        @DisplayName("못 먹는 메뉴가 3개 이상일 시 exception 발생")
        @Test
        void validateNotHaveMenuList_exception1(){
            String[] userInput = {"우동","스시","라자냐"};
            Supplier<Boolean> functionSupply = () -> validator.validateNotHaveMenuList(userInput);
            getExceptionTest(functionSupply);
        }
    }


}