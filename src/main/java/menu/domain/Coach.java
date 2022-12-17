package menu.domain;

public class Coach {
    private final String name;
    private final int minCoachNameLength = 2;
    private final int maxCoachNameLength = 4;
    private final String coachNameLengthErrorMsg = "코치이름은 " + minCoachNameLength + "~" + maxCoachNameLength + "글자 사이어야 합니다.";

    public Coach(String userInputCoach) {
        validateLengthInRange(userInputCoach);
        this.name = userInputCoach;
    }

    private void validateLengthInRange(String userInputCoach) {
        if (userInputCoach.length() < minCoachNameLength || userInputCoach.length() > maxCoachNameLength)
            throw new IllegalArgumentException(coachNameLengthErrorMsg);
    }

    public String name(){
        return name;
    }
}
