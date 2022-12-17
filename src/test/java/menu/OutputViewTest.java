package menu;

import camp.nextstep.edu.missionutils.test.NsTest;
import menu.Constant.Menu;
import menu.View.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static menu.Constant.Menu.*;
import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest extends NsTest {
    OutputView outputView = new OutputView();

    @DisplayName("카테고리 출력 테스트")
    @Test
    void printCategory() {
        List<Menu> categories = Arrays.asList(ASIAN, CHINESE, KOREAN, ASIAN, WESTERN);
        outputView.printCategory(categories);
        assertThat(output()).contains(
                "[ 카테고리 | 아시안 | 중식 | 한식 | 아시안 | 양식 ]"
        );
    }

    @Override
    protected void runMain() { }

}
