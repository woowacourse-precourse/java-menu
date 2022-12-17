package menu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ValidInputChecker {
    private static String validateCoachName(String name){
        if(name == null || name.length() < 2 || name.length() > 4)
            throw new IllegalArgumentException("[ERROR] 코치이름은 2에서 4 사이입니다.");
        return name;
    }
    public static List<String> validateCoachesAndToList(String names){
        List<String> ret = Arrays.stream(names.split(",", -1))
                .map(ValidInputChecker::validateCoachName)
                .collect(Collectors.toList());
        if(ret.size() < 2 || ret.size() >5)
            throw new IllegalArgumentException("[ERROR] 코치는 최소 2명 이상 입력해야 합니다.");
        return ret;
    }

    private static String validateFoodName(String food){
        if(food == null) return null;
        if(!FoodInformation.isExist(food))
            throw new IllegalArgumentException("[ERROR] 못 먹는 메뉴가 존재하지 않는 값입니다.");
        return food;
    }

    public static List<String> validateNoFoodsAndToList(String foods){
        List<String> ret = Arrays.stream(foods.split(",", -1))
                .map(ValidInputChecker::validateFoodName)
                .collect(Collectors.toList());
        if(ret.size() > 2)
            throw new IllegalArgumentException("[ERROR] 못 먹는 메뉴는 최대 2개 입니다.");
        return ret;
    }
}
