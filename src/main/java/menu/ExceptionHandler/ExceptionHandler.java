package menu.ExceptionHandler;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class ExceptionHandler {

    /**
     * @param supplier, 즉 예외를 발생시킬 수 있는 InputView 함수
     * @return 인자로 들어간 InputView 함수의 반환값을 반환
     * @param <T> MainScreen
     */
    public static <T> T input(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            printExceptionMessage(e);
            return input(supplier);
        }
    }

    /**
     *
     * @param consumer, 즉 예외를 발생시킬 수 있는 비즈니스(도메인) 로직의 함수
     * @param t, 비즈니스 함수가 필요로 하는 인자
     * @param <T> 이게 뭘까
     */
    public static <T> void process(Consumer<T> consumer, T t) {
        try {
            consumer.accept(t);
        } catch (IllegalArgumentException | IllegalStateException e) {
            printExceptionMessage(e);
            process(consumer, t);
        }
    }

    /*
    if (!ExceptionHandler.processNotRepeat(Controller::validateOrderHistory, orderHistory)) {
            return;
        }
     */
    public static <T, R> boolean processNotRepeat(BiConsumer<T, R> consumer, T t, R r) {
        try {
            consumer.accept(t, r);
            return true;
        } catch (IllegalArgumentException | IllegalStateException e) {
            printExceptionMessage(e);
            return false;
        }
    }

    /*
    Payment payment = ExceptionHandler.input(
                InputView::inputPaymentMethod, tableNumber);
     */
    public static <T, R> R input(Function<T, R> Function, T t) {
        try {
            return Function.apply(t);
        } catch (IllegalArgumentException e) {
            printExceptionMessage(e);
            return input(Function, t);
        }
    }

    private static void printExceptionMessage(RuntimeException e) {
        System.out.println(e.getMessage());
    }
}


