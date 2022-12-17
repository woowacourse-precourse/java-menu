package menu.parser;

import menu.exception.CoachCountException;
import menu.exception.CoachNameLengthException;
import menu.exception.CoachOverlappedException;
import menu.utils.CoachNameParser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CoachNameParserTest {
    @DisplayName("이름 리스트 반환 기능 테스트")
    @Test
    void parseToName() {
        List<String> result = CoachNameParser.parseName("김주하,하주김,김김주");
        List<String> expected = List.of("김주하", "하주김", "김김주");

        Assertions.assertThat(result).isEqualTo(expected);
    }

    @DisplayName("코치의 인원수가 요구사항을 충족하지 않을 경우")
    @Test
    void invalidCount() {
        Assertions
                .assertThatThrownBy(() -> CoachNameParser.parseName("김주하"))
                .isInstanceOf(CoachCountException.class);
    }

    @DisplayName("코치의 이름이 중복될 경우")
    @Test
    void overlappedName() {
        Assertions
                .assertThatThrownBy(() -> CoachNameParser.parseName("김주하,김주하"))
                .isInstanceOf(CoachOverlappedException.class);
    }

    @DisplayName("코치의 이름이 요구사항을 충족하지 않을 경우")
    @Test
    void invalidNameLength() {
        Assertions
                .assertThatThrownBy(() -> CoachNameParser.parseName("김주하김주하"))
                .isInstanceOf(CoachNameLengthException.class);
    }
}
