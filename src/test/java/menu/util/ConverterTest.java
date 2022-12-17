package menu.util;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConverterTest {

    @DisplayName("정상적으로 , 구분자를 통해 값을 구별하고 List로 변환하는지 테스트")
    @Test
    void 컨버터_테스트() {
        String restArray = "A,B,C,D,E,F,G";

        List<String> convertedArray =  Converter.restArrayToList(restArray);

        Assertions.assertThat(convertedArray.size()).isEqualTo(7);
    }

}