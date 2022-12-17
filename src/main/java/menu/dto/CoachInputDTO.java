package menu.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoachInputDTO {

    private String coachNames;

    public CoachInputDTO(String coachNames) {
        this.coachNames = coachNames;
    }

    public List<String> getCoachNames() {
        String[] names = coachNames.split("\\s*,\\s*");
        return new ArrayList<>(Arrays.asList(names));
    }
}
