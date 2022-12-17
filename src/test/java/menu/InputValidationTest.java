package menu;

import menu.util.InputValidation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class InputValidationTest {

    @Test
    @DisplayName("이름 중복 검사")
    void test1() {
        List<String> names = List.of("aaa", "aaa");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputValidation.validateDuplicate(names));
    }

    @Test
    @DisplayName("코치진 수 검사")
    void test2() {
        List<String> names = List.of("aaa");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputValidation.validateListSize(names));
    }

    @Test
    @DisplayName("이름 길이 검사")
    void test3() {
        List<String> names = List.of("aaaaa");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputValidation.validateNameSize(names));
    }

    @Test
    @DisplayName("음식 길이 검사")
    void test41() {
        List<String> names = List.of("양파", "피망", "마늘");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputValidation.validateHateFoodsSize(names));
    }
}
