package menu.dto;

import menu.domain.Menus;

import java.util.List;

public class NoEatDto {
    private final String coachName;
    private final List<String> noEat;

    public NoEatDto(String coachName, List<String> noEat) {
        this.coachName = coachName;
        this.noEat = noEat;
    }

    public String getCoachName() {
        return coachName;
    }

    public List<String> getNoEat() {
        return noEat;
    }
}
