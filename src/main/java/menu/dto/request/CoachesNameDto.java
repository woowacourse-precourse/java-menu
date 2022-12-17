package menu.dto.request;

import java.util.List;

public class CoachesNameDto {

    private static final int MIN_SIZE = 2;
    private static final int MAX_SIZE = 5;

    private final List<CoachNameDto> names;

    public CoachesNameDto(List<CoachNameDto> names) {
        validate(names);
        this.names = names;
    }

    public List<CoachNameDto> getNames() {
        return names;
    }

    private void validate(List<CoachNameDto> names) {
        if (names.size() < MIN_SIZE) {
            throw new IllegalArgumentException("코치는 최소 2명 이상 입력해야 합니다.");
        }

        if (names.size() > MAX_SIZE) {
            throw new IllegalArgumentException("코치는 최대 5명 입니다.");
        }
    }
}
