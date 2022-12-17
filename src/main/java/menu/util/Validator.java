package menu.util;

import java.util.List;

public class Validator {

    public static void validateCoachNamesSize(List<String> names) {
        if(names.size() < 2 || names.size () > 5){
            throw new IllegalArgumentException(
                    String.format("코치는 최소 %d명, 최대 %d명까지 식사를 함께할 수 있습니다.",2,5));
        }
    }

    public static void validateCoachNameLength(String name){
        if (name.length() < 2 || name.length() > 4){
            throw new IllegalArgumentException(
                    String.format("코치의 이름은 최소 %d글자, 최대 %d글자이다.", 2,4)
            );
        }
    }

}
