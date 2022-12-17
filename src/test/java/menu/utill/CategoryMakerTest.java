package menu.utill;

import java.util.List;
import org.junit.jupiter.api.Test;

class CategoryMakerTest {
    @Test
    void it() {
        List<String> test = CategoryMaker.make();
        System.out.println(test);

    }
}
