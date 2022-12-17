package menu;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LearningTest {
    @Test
    void name() {

        int i = Randoms.pickNumberInList(List.of(1, 2, 3, 4));
        int count = 1;
        System.out.println(count >= 1);
    }
}
