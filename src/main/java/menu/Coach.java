package menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Coach {
    List<String> coaches;

    public Coach(String input){
        split(input);
        validateName(coaches);
        validateMany(coaches);
    }

    private void split(String input){
        String[] temp = input.split(",");
        coaches = new ArrayList<>(Arrays.asList(temp));
    }

    private void validateName(List<String> coaches) {
        for(String coach : coaches){
            validateNameLength(coach);
        }
    }

    private void validateNameLength(String coach){
        if(coach.length() < 2 || coach.length() > 4){
            throw new IllegalArgumentException(ErrorMessage.PREFIX+ErrorMessage.INVALID_COACH_NAME);
        }
    }

    private void validateMany(List<String> coaches) {
        if(coaches.size() < 2 || coaches.size() >5){
            throw new IllegalArgumentException(ErrorMessage.PREFIX+ErrorMessage.INVALID_COACH_LENGTH);
        }
    }
}
