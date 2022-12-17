package menu.controller.mapper;

import menu.domain.Coach;
import menu.domain.Group;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toUnmodifiableList;

public class CoachMapper {

    private static final String ERROR_SIZE_UNDER_FORMAT = "코치는 최소 %d명 이상 입력해야 합니다.";
    private static final String ERROR_SIZE_OVER_FORMAT = "코치는 최대 %d명 까지만 입력해야 합니다.";

    private static final String COMMA = ",";
    private static final int MIN_GROUP_SIZE = 2;
    private static final int MAX_GROUP_SIZE = 5;

    public static Group toGroup(final String names) {
        String[] split = names.split(COMMA);
        validateSize(split);
        // TODO 이름 글자 수 검증
        return new Group(stream(split)
                .map(Coach::ofName)
                .collect(toUnmodifiableList()));
    }

    private static void validateSize(final String[] split) {
        if (MIN_GROUP_SIZE > split.length) {
            throw new IllegalArgumentException(String.format(ERROR_SIZE_UNDER_FORMAT, MIN_GROUP_SIZE));
        }
        if (MAX_GROUP_SIZE < split.length) {
            throw new IllegalArgumentException(String.format(ERROR_SIZE_OVER_FORMAT, MAX_GROUP_SIZE));
        }
    }
}
