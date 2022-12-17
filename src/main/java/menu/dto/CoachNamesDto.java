package menu.dto;

import java.util.List;

public class CoachNamesDto {
    private final List<String> names;

    public CoachNamesDto(List<String> names) {
        this.names = names;
    }

    public List<String> getNames() {
        return names;
    }
}
