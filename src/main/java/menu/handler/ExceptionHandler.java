package menu.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 예외 발생시 재시도 하도록 프록시를 생성하는 클래스
 */
public class ExceptionHandler implements InvocationHandler {

    private static final String EXCEPTION_MESSAGE_PREFIX = "[ERROR] ";

    private final Object target;

    public ExceptionHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            return method.invoke(target, args);
        } catch (InvocationTargetException exception) {
            if (exception.getTargetException() instanceof IllegalArgumentException) {
                printExceptionMessage(exception);
                return invoke(proxy, method, args);
            }

            throw exception.getTargetException();
        }
    }

    private void printExceptionMessage(InvocationTargetException exception) {
        Throwable targetException = exception.getTargetException();
        System.out.println(EXCEPTION_MESSAGE_PREFIX + targetException.getMessage());
    }

}
