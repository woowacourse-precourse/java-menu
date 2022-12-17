package menu.exception;

import java.util.List;

public class InputException {

    public void validateNameSizeFormat(String name) {
        if(name.length()<2||name.length()>4) {
            throw new IllegalArgumentException(ErrorMessage.SIZE_FORMAT_ERROR);
        }
    }
    public void validateQuantityFormat(List<String> coaches) {
        if(coaches.size()<2 || coaches.size()>5) {
            throw new IllegalArgumentException(ErrorMessage.QUANTITY_FORMAT_ERROR);
        }
    }

}
