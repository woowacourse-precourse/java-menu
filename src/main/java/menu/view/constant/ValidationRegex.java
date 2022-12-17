package menu.view.constant;

import java.util.regex.Pattern;

public enum ValidationRegex {
    EMPTY("^$"),
    NUMBER("^[0-9]+$");

    private final String regex;
    
    ValidationRegex(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
