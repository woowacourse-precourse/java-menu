package menu.domain.coach;

import menu.validator.domain.InputCoachNameValidator;

import java.util.Objects;

public class CoachName {
    private final String coachName;
    
    public CoachName(String coachName) {
        InputCoachNameValidator.validate(coachName);
        this.coachName = coachName;
    }
    
    public String name() {
        return coachName;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoachName coachName1 = (CoachName) o;
        return Objects.equals(coachName, coachName1.coachName);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(coachName);
    }
    
    @Override
    public String toString() {
        return "CoachName{" +
                "coachName='" + coachName + '\'' +
                '}';
    }
}
