package menu.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Coach {

    private static final String RANGE_ERROR_MSG = "이름은 2-4 글자여야 합니다";
    private static final String INEDIBLES_RANGE_ERROR_MSG = "최대 2개의 메뉴만 입력 가능합니다";
    private static final String INEDIBLES_NOT_EXIST_MENU_ERROR_MSG = "없는 메뉴입니다";
    private static final Integer MIN_SIZE_NAME = 2;
    private static final Integer MAX_SIZE_NAME = 4;

    private static final Integer MAX_SIZE_INEDIBLES = 2;
    private final String name;
    private List<String> inedibles;

    public Coach(String name) {
        validateName(name);
        this.name = name;
    }

    private Coach(String name, List<String> inedibles) {
        validateName(name);
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

    public String getName() {
        return name;
    }

    public void addInedibles(String input_inedibles){
        List<String> input_inedibles_List = Arrays.stream(input_inedibles.split(","))
                .collect(Collectors.toList());

        validateInediblesExist(input_inedibles_List);
        validateInediblesSize(input_inedibles_List);

        inedibles = input_inedibles_List;
    }

    private void validateInediblesExist(List<String> input_inedibles_List){
        for(String menu : input_inedibles_List){
            if(!FoodCategory.isExistMenu(menu))
                throw new IllegalArgumentException(INEDIBLES_NOT_EXIST_MENU_ERROR_MSG);
        }
    }

    private void validateInediblesSize(List<String> input_inedibles_List){
        if(input_inedibles_List.size()>MAX_SIZE_INEDIBLES)
            throw new IllegalArgumentException(INEDIBLES_RANGE_ERROR_MSG);
    }
}
