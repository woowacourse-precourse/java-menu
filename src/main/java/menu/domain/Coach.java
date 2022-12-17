package menu.domain;

import java.util.Collections;
import java.util.List;

public class Coach {

    private static final String RANGE_ERROR_MSG = "이름은 2-4 글자여야 합니다";
    private static final Integer MIN_SIZE_NAME = 2;
    private static final Integer MAX_SIZE_NAME = 4;
    private final String name;
    private List<String> inedibles;

    public Coach(String name) {
        this.name = name;
    }

    private Coach(String name, List<String> inedibles) {
        this.name = name;
        this.inedibles = inedibles;
    }

    public static Coach from(String name){
        return new Coach(name);
    }

    public static Coach of(String name, List<String> inedibles){
        return new Coach(name,inedibles);
    }

    private void validateName(String name){
        if(name.length()<MIN_SIZE_NAME || name.length()>MAX_SIZE_NAME) throw new IllegalArgumentException(RANGE_ERROR_MSG);
    }
}
