package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayName("RandomPicker 클래스")
@DisplayNameGeneration(ReplaceUnderscores.class)
class RandomPickerTest {

    @Test
    void pickRandomInRange_메서드는_시작범위와_끝범위_사이의_수가_반환된다() {
        assertThat(new RandomPicker().pickNumberInRange(1, 5)).isBetween(1, 5);
    }
}
