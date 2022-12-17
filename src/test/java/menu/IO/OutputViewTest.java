package menu.IO;

import menu.model.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {
    private OutputView outputView;
    private OutputStream outputStream;

    @BeforeEach
    void init() {
        outputView = new OutputView();
    }

    @BeforeEach
    void outputStreamInit() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }


    @DisplayName("시작메시지")
    @Test
    void 시작메시지() {
        final String output = "점심 메뉴 추천을 시작합니다.\n";
        outputView.startMsg();
        assertThat(outputStream.toString()).isEqualTo(output);
    }

    @DisplayName("새줄")
    @Test
    void 새줄() {
        final String output = "\n";
        outputView.newLine();
        assertThat(outputStream.toString()).isEqualTo(output);
    }

    @DisplayName("코치이름입력")
    @Test
    void 코치이름입력() {
        final String output = "코치의 이름을 입력해 주세요. (, 로 구분)\n";
        outputView.promptReadCoachName();
        assertThat(outputStream.toString()).isEqualTo(output);
    }

    @DisplayName("못먹는 음식 입력")
    @Test
    void 못먹는_음식_입력() {
        final String output = "토미(이)가 못 먹는 메뉴를 입력해 주세요.\n";
        outputView.promptDontEatMenuCoach("토미");
        assertThat(outputStream.toString()).isEqualTo(output);
    }

    @DisplayName("결과 출력")
    @Test
    void 결과_출력() {
        final String output = "메뉴 추천 결과입니다.\n" +
                "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]\n" +
                "[ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]\n" +
                "[ 토미 | 쌈밥 | 김치찌개 | 미소시루 | 짜장면 | 팟타이 ]\n";
        outputView.printResult(Arrays.asList("토미"), Arrays.asList(Category.KOREAN, Category.KOREAN, Category.JAPANESE, Category.CHINESE, Category.ASIAN), Arrays.asList(Arrays.asList("쌈밥", "김치찌개", "미소시루", "짜장면", "팟타이")));
        assertThat(outputStream.toString()).isEqualTo(output);
    }

    @DisplayName("종료메시지")
    @Test
    void 종료메시지() {
        final String output = "추천을 완료했습니다.\n";
        outputView.endingMsg();
        assertThat(outputStream.toString()).isEqualTo(output);
    }

}