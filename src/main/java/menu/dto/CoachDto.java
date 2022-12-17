package menu.dto;

import java.util.List;

public class CoachDto {
    private final String coachName;
    private final List<String> noEats;

    public CoachDto(String coachName, List<String> noEats) {
        this.coachName = coachName;
        this.noEats = noEats;
    }

    public String getCoachName() {
        return coachName;
    }

    public List<String> getNoEats() {
        return noEats;
    }
}
