package menu;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import menu.util.Validate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.MockedStatic;

public class ApplicationTest extends NsTest {
    private static final String ERROR_DIFFERENT_LENGTHS = "[ERROR] 코치의 이름은 최소 2글자, 최대 4글자이다.";
    private static final String ERROR_DIFFERENT_COACH_LENGTHS = "[ERROR] 코치는 최소 2명, 최대 5명까지 식사를 함께 한다.";
    private static final String ERROR_DIFFERENT_CANT_EAT_LENGTHS = "[ERROR] 각 코치는 최소 0개, 최대 2개의 못 먹는 메뉴가 있다.";
    private static final String ERROR_DUPLICATE_VALUE = "[ERROR] 중복 값이 포함되어 있습니다.";
    private static final String ERROR_NUMBER = "[ERROR] 이름이 아닙니다.";

    private static final Duration RANDOM_TEST_TIMEOUT = Duration.ofSeconds(10L);

    @DisplayName("전체 기능 테스트")
    @Nested
    class AllFeatureTest {
        @Test
        void Validate_이름_길이_테스트_1() {
            assertSimpleTest(() -> {
                try {
                    Validate.nameLength(Arrays.asList("엘리스", "바이", "퀸"), 2, 4);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                assertThat(output()).contains(ERROR_DIFFERENT_LENGTHS);
            });
        }

        @Test
        void Validate_이름_길이_테스트_2() {
            assertSimpleTest(() -> {
                try {
                    Validate.nameLength(Arrays.asList("엘리스", "바이", "이즈리얼", "모데카이저"), 2, 4);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                assertThat(output()).contains(ERROR_DIFFERENT_LENGTHS);
            });
        }

        @Test
        void Validate_못_먹는_음식_중복_테스트() {
            assertSimpleTest(() -> {
                try {
                    Validate.duplication(Arrays.asList("치킨", "피자", "치킨"));
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                assertThat(output()).contains(ERROR_DUPLICATE_VALUE);
            });
        }

        @Test
        void Validate_한글_이름_공백_테스트() {
            assertSimpleTest(() -> {
                try {
                    Validate.isName("가나 다");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                assertThat(output()).contains(ERROR_NUMBER);
            });
        }

        @Test
        void Validate_영문_한글_혼합_포함_에러_테스트() {
            assertSimpleTest(() -> {
                try {
                    Validate.isName("안녕a");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                assertThat(output()).contains(ERROR_NUMBER);
            });
        }

        @Test
        void Validate_숫자_값_포함_에러_테스트_1() {
            assertSimpleTest(() -> {
                try {
                    Validate.isName("안녕3");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                assertThat(output()).contains(ERROR_NUMBER);
            });
        }

        @Test
        void Validate_숫자_값_포함_에러_테스트_2() {
            assertSimpleTest(() -> {
                try {
                    Validate.isName("7안녕하세요");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                assertThat(output()).contains(ERROR_NUMBER);
            });
        }

        @Test
        void Validate_숫자_값_포함_에러_테스트_3() {
            assertSimpleTest(() -> {
                try {
                    Validate.isName("abc0");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                assertThat(output()).contains(ERROR_NUMBER);
            });
        }

        @Test
        void Validate_못_먹는_음식_개수_초과_테스트() {
            assertSimpleTest(() -> {
                try {
                    Validate.cantEatLength(Arrays.asList("치킨", "피자", "치킨"), 0, 2);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                assertThat(output()).contains(ERROR_DIFFERENT_CANT_EAT_LENGTHS);
            });
        }

        @Test
        void Validate_코치_수_초과_테스트() {
            assertSimpleTest(() -> {
                try {
                    Validate.coachLength(Arrays.asList("김씨", "김씨", "김씨", "김씨", "김씨", "송씨"), 2, 5);
                    // 이름이 같은 경우도 있을수 있기때문에 예외처리를 해주지않았다
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                assertThat(output()).contains(ERROR_DIFFERENT_COACH_LENGTHS);
            });
        }

        @Test
        void Validate_코치_수_미만_테스트() {
            assertSimpleTest(() -> {
                try {
                    Validate.coachLength(Arrays.asList("김씨"), 2, 5);
                    // 이름이 같은 경우도 있을수 있기때문에 예외처리를 해주지않았다
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                assertThat(output()).contains(ERROR_DIFFERENT_COACH_LENGTHS);
            });
        }

        @Test
        void 이름에_숫자_포함_예외_테스트() {
            assertSimpleTest(() -> {
                runException("토미,제임1스,포코");
                assertThat(output()).contains(ERROR_NUMBER);
            });
        }

        @Test
        void 코치_못_먹는_음식_중복_예외_테스트() {
            assertSimpleTest(() -> {
                runException("토미,제임스,포코", "우동,스시", "스시,스시");
                assertThat(output()).contains(ERROR_DUPLICATE_VALUE);
            });
        }

        @Test
        void 코치_못_먹는_음식_예외_테스트() {
            assertSimpleTest(() -> {
                runException("토미,제임스,포코", "우동,스시", "우동,스시,마파두부");
                assertThat(output()).contains(ERROR_DIFFERENT_CANT_EAT_LENGTHS);
            });
        }

        @Test
        void 코치_수_예외_테스트() {
            assertSimpleTest(() -> {
                runException("토미,제임스,포코,코코,렉사이,엘리스");
                assertThat(output()).contains(ERROR_DIFFERENT_COACH_LENGTHS);
            });
        }

        @Test
        void 코치_이름_예외_테스트() {
            assertSimpleTest(() -> {
                runException("토미,제임스,포코모코코");
                assertThat(output()).contains(ERROR_DIFFERENT_LENGTHS);
            });
        }

        @Test
        void 중복_카테고리가_랜덤_값_으로_나왔을때() {
            assertTimeoutPreemptively(RANDOM_TEST_TIMEOUT, () -> {
                final Executable executable = () -> {
                    runException("구구,제임스", "비빔밥", "떡볶이");

                    assertThat(output()).contains(
                            "점심 메뉴 추천을 시작합니다.",
                            "코치의 이름을 입력해 주세요. (, 로 구분)",
                            "구구(이)가 못 먹는 메뉴를 입력해 주세요.",
                            "제임스(이)가 못 먹는 메뉴를 입력해 주세요.",
                            "메뉴 추천 결과입니다.",
                            "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]",
                            "[ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]",
                            "[ 구구 | 김치찌개 | 쌈밥 | 규동 | 짜장면 | 카오 팟 ]",
                            "[ 제임스 | 제육볶음 | 된장찌개 | 가츠동 | 짬뽕 | 파인애플 볶음밥 ]",
                            "추천을 완료했습니다."
                    );
                };

                assertRandomTest(executable,
                        Mocking.ofRandomNumberInRange(2, 2, 2, 2, 2, 2, 2, 1, 3, 4),   // 카테고리가 중복되었을때 다시 랜덤을 함수를 돌린다.
                        Mocking.ofShuffle(
                                // 월요일
                                List.of("김치찌개", "김밥", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"),    // 구구
                                List.of("제육볶음", "김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이"),    // 제임스

                                // 화요일
                                List.of("쌈밥", "김치찌개", "김밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"),    // 구구
                                List.of("된장찌개", "제육볶음", "김밥", "김치찌개", "쌈밥", "비빔밥", "칼국수", "불고기", "떡볶이"),    // 제임스

                                // 수요일
                                List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"),  // 구구
                                List.of("가츠동", "규동", "우동", "미소시루", "스시", "오니기리", "하이라이스", "라멘", "오코노미야끼"),  // 제임스

                                // 목요일
                                List.of("짜장면", "깐풍기", "볶음면", "동파육", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"),   // 구구
                                List.of("짬뽕", "깐풍기", "볶음면", "동파육", "짜장면", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"),   // 제임스

                                // 금요일
                                List.of("카오 팟", "팟타이", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"),    // 구구
                                List.of("파인애플 볶음밥", "팟타이", "카오 팟", "나시고렝", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")     // 제임스
                        )
                );
            });
        }

        @Test
        void 못_먹는_메뉴_셔플_테스트() {
            assertTimeoutPreemptively(RANDOM_TEST_TIMEOUT, () -> {
                final Executable executable = () -> {
                    runException("구구,제임스", "김치찌개,김밥", "떡볶이");

                    assertThat(output()).contains(
                            "점심 메뉴 추천을 시작합니다.",
                            "코치의 이름을 입력해 주세요. (, 로 구분)",
                            "구구(이)가 못 먹는 메뉴를 입력해 주세요.",
                            "제임스(이)가 못 먹는 메뉴를 입력해 주세요.",
                            "메뉴 추천 결과입니다.",
                            "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]",
                            "[ 카테고리 | 한식 | 양식 | 일식 | 중식 | 아시안 ]",
                            "[ 구구 | 떡볶이 | 스파게티 | 규동 | 짜장면 | 카오 팟 ]",
                            "[ 제임스 | 제육볶음 | 라자냐 | 가츠동 | 짬뽕 | 파인애플 볶음밥 ]",
                            "추천을 완료했습니다."
                    );
                };

                assertRandomTest(executable,
                        Mocking.ofRandomNumberInRange(2, 5, 1, 3, 4),   // 숫자는 카테고리 번호를 나타낸다.
                        Mocking.ofShuffle(
                                // 월요일
                                List.of("김치찌개", "김밥", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"),    // 구구
                                List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"),    // 구구
                                List.of("떡볶이", "김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"),    // 구구
                                List.of("제육볶음", "김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이"),    // 제임스

                                // 화요일
                                List.of("스파게티", "라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "피자", "파니니"),   // 구구
                                List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"),   // 제임스

                                // 수요일
                                List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"),  // 구구
                                List.of("가츠동", "규동", "우동", "미소시루", "스시", "오니기리", "하이라이스", "라멘", "오코노미야끼"),  // 제임스

                                // 목요일
                                List.of("짜장면", "깐풍기", "볶음면", "동파육", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"),   // 구구
                                List.of("짬뽕", "깐풍기", "볶음면", "동파육", "짜장면", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"),   // 제임스

                                // 금요일
                                List.of("카오 팟", "팟타이", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"),    // 구구
                                List.of("파인애플 볶음밥", "팟타이", "카오 팟", "나시고렝", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")     // 제임스
                        )
                );
            });
        }

        @Test
        void 기능_테스트() {
            assertTimeoutPreemptively(RANDOM_TEST_TIMEOUT, () -> {
                final Executable executable = () -> {
                    runException("구구,제임스", "김밥", "떡볶이");

                    assertThat(output()).contains(
                            "점심 메뉴 추천을 시작합니다.",
                            "코치의 이름을 입력해 주세요. (, 로 구분)",
                            "구구(이)가 못 먹는 메뉴를 입력해 주세요.",
                            "제임스(이)가 못 먹는 메뉴를 입력해 주세요.",
                            "메뉴 추천 결과입니다.",
                            "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]",
                            "[ 카테고리 | 한식 | 양식 | 일식 | 중식 | 아시안 ]",
                            "[ 구구 | 김치찌개 | 스파게티 | 규동 | 짜장면 | 카오 팟 ]",
                            "[ 제임스 | 제육볶음 | 라자냐 | 가츠동 | 짬뽕 | 파인애플 볶음밥 ]",
                            "추천을 완료했습니다."
                    );
                };

                assertRandomTest(executable,
                        Mocking.ofRandomNumberInRange(2, 5, 1, 3, 4),   // 숫자는 카테고리 번호를 나타낸다.
                        Mocking.ofShuffle(
                                // 월요일
                                List.of("김치찌개", "김밥", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"),    // 구구
                                List.of("제육볶음", "김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이"),    // 제임스

                                // 화요일
                                List.of("스파게티", "라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "피자", "파니니"),   // 구구
                                List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"),   // 제임스

                                // 수요일
                                List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"),  // 구구
                                List.of("가츠동", "규동", "우동", "미소시루", "스시", "오니기리", "하이라이스", "라멘", "오코노미야끼"),  // 제임스

                                // 목요일
                                List.of("짜장면", "깐풍기", "볶음면", "동파육", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"),   // 구구
                                List.of("짬뽕", "깐풍기", "볶음면", "동파육", "짜장면", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"),   // 제임스

                                // 금요일
                                List.of("카오 팟", "팟타이", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"),    // 구구
                                List.of("파인애플 볶음밥", "팟타이", "카오 팟", "나시고렝", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")     // 제임스
                        )
                );
            });
        }
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

    private static void assertRandomTest(
            final Executable executable,
            final Mocking... mockings
    ) {
        assertTimeoutPreemptively(RANDOM_TEST_TIMEOUT, () -> {
            try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
                Arrays.stream(mockings).forEach(mocking -> mocking.stub(mock));
                executable.execute();
            }
        });
    }

    public static class Mocking<T> {

        /**
         * stubbing lambda verification 예시) () -> Randoms.pickNumberInList(anyList())
         */
        private final MockedStatic.Verification verification;

        // 반환할 첫 번째 값
        private final T value;

        /**
         * 첫 번째 값을 반환하고 나서 다음에 반환할 값들. 예를 들면, verification을 처음 실행하면 value를 반환하고 두 번째 실행하면 values[0]을
         * 반환한다.
         */
        private final T[] values;

        private Mocking(final MockedStatic.Verification verification,
                        final T value,
                        final T... values) {
            this.verification = verification;
            this.value = value;
            this.values = values;
        }

        public static Mocking ofRandomNumberInRange(final Integer value, final Integer... values) {
            return new Mocking(() -> Randoms.pickNumberInRange(anyInt(), anyInt()), value, values);
        }

        public static <T> Mocking ofShuffle(final List<T> value, final List<T>... values) {
            return new Mocking(() -> Randoms.shuffle(anyList()), value, values);
        }

        public <S> void stub(final MockedStatic<S> mock) {
            mock.when(verification).thenReturn(value, Arrays.stream(values).toArray());
        }
    }
}
