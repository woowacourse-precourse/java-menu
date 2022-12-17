package menu.domain;

import menu.utils.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CouchTest {

    @Test
    void Couch_객체의_이름이_2글자_4글자_사이가_아니면_예외() {
        Assertions.assertThatThrownBy(() -> Couch.from("김"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.COUCH_NAME_OUT_OF_RANGE.getMessage());
    }

    @Test
    void Couch_객체의_이름은_앞뒤_공백을_무시한다() {
        Couch couch = Couch.from(" 최최준호 ");
        Assertions.assertThat(couch.getName()).isEqualTo("최최준호");
    }


    @Nested
    class recommend_메소드에_대해서 {
        @Test
        void recommend_메소드를_실행하면_해당_Food에_대해_isDeny_True() {

        }

        @Test
        void recommend_메소드를_실행하면_해당_Food에_대해_isDeny_True() {

        }
    }


    @Test
    void denyFood_메소드를_실행하면_해당_Food에_대해_isDeny_True() {

    }

    @Test
    void toMessage_메소드는_다음_형태에_맞춰_출력한다() {
        String string = "";
    }

}