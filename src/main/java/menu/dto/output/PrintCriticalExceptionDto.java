package menu.dto.output;

public class PrintCriticalExceptionDto {
    private final Exception exception;

    public PrintCriticalExceptionDto(Exception exception) {
        this.exception = exception;
    }

    public Exception getException() {
        return exception;
    }
}
