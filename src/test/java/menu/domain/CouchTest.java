package menu.domain;

import menu.utils.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CouchTest {

    @Test
    void Couch_객체의_이름이_2글자_4글자_사이가_아니면_예외() {
        Assertions.assertThatThrownBy(() -> Couch.from("김"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.COUCH_NAME_OUT_OF_RANGE.getMessage());
    }

}