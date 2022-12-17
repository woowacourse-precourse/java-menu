package menu.dto;

import java.util.List;

public class CoachesDto {
    private final List<CoachDto> coaches;

    public CoachesDto(List<CoachDto> coaches) {
        this.coaches = coaches;
    }

    public List<CoachDto> getCoaches() {
        return coaches;
    }
}
