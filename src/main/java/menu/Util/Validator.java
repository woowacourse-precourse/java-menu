package menu.Util;


import java.util.Arrays;
import java.util.List;

public class Validator {
    public static List<String> validateCoachList(String coachesInput) {
        List<String> coachList = Arrays.asList(coachesInput.split(","));
        validateCoachNameSize(coachList);
        if (coachList.size() > 5 || coachList.size() < 2) {
            throw new IllegalArgumentException(ErrorMessage.CoachNumber.getMessage());
        }
        return coachList;
    }

    public static List<String> validateAllergyList(String allergyInput) {
        List<String> allergyList = Arrays.asList(allergyInput.split(","));
        if (allergyList.size() > 2) {
            throw new IllegalArgumentException(ErrorMessage.Allergic.getMessage());
        }
        return allergyList;
    }


    private static void validateCoachNameSize(List<String> names) {
        for (String name :
                names) {
            if (name.length() > 4 || name.length() < 2) {
                throw new IllegalArgumentException(ErrorMessage.CoachNameSize.getMessage());
            }
        }
    }


}
