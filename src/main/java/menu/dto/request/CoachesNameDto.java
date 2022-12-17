package menu.dto.request;

import java.util.List;

public class CoachesNameDto {

    private final static int MIN_SIZE = 2;
    private final static int MAX_SIZE = 5;

    private final List<CoachNameDto> names;

    public CoachesNameDto(List<CoachNameDto> names) {
        validate(names);
        this.names = names;
    }

    private void validate(List<CoachNameDto> names) {
        if (names.size() < MIN_SIZE) {
            throw new IllegalArgumentException("코치는 최소 2명 이상 입력해야 합니다.");
        }

        if (names.size() > MAX_SIZE) {
            throw new IllegalArgumentException("코치는 최대 5명 입니다.");
        }
    }

    public List<CoachNameDto> getNames() {
        return names;
    }
}
