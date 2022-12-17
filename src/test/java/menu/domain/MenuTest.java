package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("Menu")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
public class MenuTest {

    @Test
    void getName_메서드는_메뉴명을_반환한다() {
        Menu menu = new Menu("음식");

        assertThat(menu.getName()).isEqualTo("음식");
    }
}
