package menu.controller.util;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class ExceptionHandler {
    // 실행
    public static void retryForIllegalArgument(Runnable runnable, Consumer<String> exceptionMessageHandling) {
        while (true) {
            try {
                runnable.run();
                return;
            } catch (IllegalArgumentException exception) {
                exceptionMessageHandling.accept(exception.getMessage());
            }
        }
    }

    // 값 반환
    public static <T> T retryForIllegalArgument(Supplier<T> supplier, Consumer<String> exceptionMessageHandling) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException exception) {
                exceptionMessageHandling.accept(exception.getMessage());
            }
        }
    }

    // 입력 -> 도메인 로직으로 객체 생성까지 해야 검증될 때
    public static <T, R> R retryForIllegalArgument(Function<T, R> domain, Supplier<T> input,
                                                   Consumer<String> exceptionMessageHandling) {
        while (true) {
            try {
                return domain.apply(input.get());
            } catch (IllegalArgumentException exception) {
                exceptionMessageHandling.accept(exception.getMessage());
            }
        }
    }
}
