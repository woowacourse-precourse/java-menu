package menu.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FoodCategoryTest {

    @DisplayName("findByNumber 메소드")
    @ParameterizedTest(name = "{index} : {0}을 넣으면 {1}을 반환한다.")
    @CsvSource({"1, JAPANESE", "2, KOREAN", "3, CHINESE", "4, ASIAN", "5, WESTERN"})
    void findByNumber(int number,  FoodCategory expected) {
        FoodCategory actual = FoodCategory.findByNumber(number);
        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
