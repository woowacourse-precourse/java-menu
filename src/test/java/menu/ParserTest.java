package menu;

import menu.util.Parser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ParserTest {
    @Test
    void parserTest(){
        Parser parser = new Parser();
        List<String> parse = parser.parse("토미,제임스,포코");
        assertThat(parse.size()).isEqualTo(3);
        assertThat(parse.get(0)).isEqualTo("토미");
        assertThat(parse.get(1)).isEqualTo("제임스");
        assertThat(parse.get(2)).isEqualTo("포코");
    }
}
