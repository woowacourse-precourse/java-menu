package menu.exception;

public class CustomIllegalArgumentException extends IllegalArgumentException {
    public CustomIllegalArgumentException(String message){
        super("[ERROR] " + message);
    }
}
