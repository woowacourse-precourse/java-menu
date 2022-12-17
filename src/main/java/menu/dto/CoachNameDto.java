package menu.dto;

import java.util.List;

public class CoachNameDto {

    List<String> names;

    public CoachNameDto(List<String> names) {
        this.names = names;
    }

    public List<String> getNames() {
        return names;
    }
}
