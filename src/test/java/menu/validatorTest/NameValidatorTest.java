package menu.validatorTest;

import menu.validator.NameValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class NameValidatorTest {

    @DisplayName("코치의 수가 1명일 때 예외가 발생하는지 확인")
    @Test
    public void checkInValidateCoachMINCount(){
        List<String> names = Arrays.asList("코치1");

        assertThatThrownBy(() -> new NameValidator().validate(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("코치의 수가 6명일 때 예외가 발생하는지 확인")
    @Test
    public void checkInValidateCoachMAXCount(){
        List<String> names = Arrays.asList("코치1,코치2,코치3,코치4,코치5,코치6");

        assertThatThrownBy(() -> new NameValidator().validate(names))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
