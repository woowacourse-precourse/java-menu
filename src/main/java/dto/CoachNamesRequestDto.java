package dto;

public class CoachNamesRequestDto {
    private final String coachNames;

    public CoachNamesRequestDto(String coachNames) {
        this.coachNames = coachNames;
    }

    public String getCoachNames() {
        return coachNames;
    }
}
