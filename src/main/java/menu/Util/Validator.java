package menu.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validator {
    public static List<String> validateCoachList(String coachesInput) {
        List<String> coachList = Arrays.asList(coachesInput.split(","));
        if (coachList.size() > 5 || coachList.size() < 2) {
            throw new IllegalArgumentException("같이 밥을 먹는 코치 수가 아닙니다!");
        }
        return coachList;
    }

    public static List<String> validateAllergyList(String allergyInput){
        List<String> allergyList = Arrays.asList(allergyInput.split(","));
        if(allergyList.size() > 2){
            throw new IllegalArgumentException("[ERROR] 못먹는 음식은 0개 이상 2개 이하여야 합니다!");
        }
        return allergyList;
    }




    private static void validateCoachNameSize(List<String> names) {
        for (String name :
                names) {
            if (name.length() > 4 || name.length() < 2) {
                throw new IllegalArgumentException("[ERROR] 코치의 수는 2명 이상 4명 이하여야 합니다.");
            }
        }
    }
}
