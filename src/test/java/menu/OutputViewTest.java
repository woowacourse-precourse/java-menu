package menu;

import camp.nextstep.edu.missionutils.test.NsTest;
import menu.Constant.Menu;
import menu.View.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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

    @DisplayName("코치 별 추천 결과 출력 테스트")
    @Test
    void printEachResults() {

        Coach coach1 = new Coach("제임스", Arrays.asList(""));
        coach1.addRecommend("된장찌개");
        coach1.addRecommend("비빔밥");
        coach1.addRecommend("가츠동");
        coach1.addRecommend("토마토 달걀볶음");
        coach1.addRecommend("파인애플 볶음밥");
        Coach coach2 = new Coach("포코", Arrays.asList(""));
        coach2.addRecommend("된장찌개");
        coach2.addRecommend("불고기");
        coach2.addRecommend("하이라이스");
        coach2.addRecommend("탕수육");
        coach2.addRecommend("나시고렝");

        List<Coach> coaches = new ArrayList<>(Arrays.asList(coach1, coach2));

        outputView.printCoachesResult(coaches);
        assertThat(output()).contains(
                "[ 제임스 | 된장찌개 | 비빔밥 | 가츠동 | 토마토 달걀볶음 | 파인애플 볶음밥 ]",
                "[ 포코 | 된장찌개 | 불고기 | 하이라이스 | 탕수육 | 나시고렝 ]"
        );
    }

    @Override
    protected void runMain() { }

}
