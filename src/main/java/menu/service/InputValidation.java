package menu.service;

public class InputValidation {

    public boolean isValidCoachName(String coachName){
        try {
            if (coachName.length() < 2 || coachName.length() > 4)
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    
}
