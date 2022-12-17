package menu.validator;

import java.util.List;

public class BaseValidator {

    public static boolean verifyNameDistinction(List<String> names) {
        return names.stream().distinct().count() == names.size();
    }
}
