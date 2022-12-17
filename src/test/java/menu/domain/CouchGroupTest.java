package menu.domain;

import menu.utils.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CouchGroupTest {

    @Test
    void CouchGroup_객체가_중복된_이름의_Couch를_가지면_예외() {
        List<Couch> couches = List.of(Couch.from("최준호"),
                Couch.from("최준호"),
                Couch.from("김준호"));

        Assertions.assertThatThrownBy(() -> CouchGroup.from(couches))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.COUCH_NAME_DUPLICATE.getMessage());
    }

    @Test
    void Couch가_2명에서_5명사이가_아니면_예외() {
        List<Couch> couches = List.of(Couch.from("최준호"),
                Couch.from("박준호"),
                Couch.from("이준호"),
                Couch.from("성준호"),
                Couch.from("나준호"),
                Couch.from("김준호"));
        Assertions.assertThatThrownBy(() -> CouchGroup.from(couches))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.COUCH_GROUP_OUT_OF_RANGE.getMessage());
    }

}