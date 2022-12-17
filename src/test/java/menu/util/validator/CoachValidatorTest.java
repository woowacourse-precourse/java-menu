package menu.util.validator;

import menu.util.constants.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CoachValidatorTest {

    @Test
    void 코치_이름_공백_검증() {
        String coachName = "포비,,제임스";

        Assertions.assertThatCode(() -> CoachValidator.validateCoach(coachName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.COACH_NAME_NOT_EMPTY);
    }

    @Test
    void 코치_이름_글자_제한() {
        String coachName = "포비,무궁화삼천리,제임스";

        Assertions.assertThatCode(() -> CoachValidator.validateCoach(coachName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.COACH_NAME_LENGTH);
    }

    @Test
    void 코치_이름_중복_검증() {
        String coachName = "포비,포비,제임스";

        Assertions.assertThatCode(() -> CoachValidator.validateCoach(coachName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.COACH_NAME_DUPLICATE);
    }

    @Test
    void 코치_인원_제한() {
        String coachName = "포비,제임스,미키,하하,그레이,카사";

        Assertions.assertThatCode(() -> CoachValidator.validateCoach(coachName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.COACH_NUMBER);
    }

}