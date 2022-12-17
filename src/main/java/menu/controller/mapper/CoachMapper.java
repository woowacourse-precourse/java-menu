package menu.controller.mapper;

import menu.domain.Coach;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class CoachMapper {

    private static final String COMMA = ",";
    private static final int MIN_GROUP_SIZE = 2;
    private static final int MAX_GROUP_SIZE = 5;

    public static List<Coach> toCoaches(String names) {
        String[] split = names.split(COMMA);
        validateSize(split);
        // TODO 이름 글자 수 검증
        return stream(split)
                .map(Coach::ofName)
                .collect(Collectors.toUnmodifiableList());
    }

    private static void validateSize(String[] split) {
        if (MIN_GROUP_SIZE > split.length) {
            throw new IllegalArgumentException("코치는 최소 2명 이상 입력해야 합니다.");
        }
        if (MAX_GROUP_SIZE < split.length) {
            throw new IllegalArgumentException("코치는 최대 5명 까지만 입력해야 합니다.");
        }
    }
}
