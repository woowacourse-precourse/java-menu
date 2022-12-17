package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class CategoryTest {
    @DisplayName("test")
    @RepeatedTest(50)
    void it_returns() {
        List<String> list = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));
        String result = list.get(Randoms.pickNumberInRange(0, 4));
        System.out.println(result);
    }

}
