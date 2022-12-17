package menu.domain;

import menu.utils.ErrorMessage;

import java.util.List;
import java.util.StringJoiner;

public class CoachGroup {

    private final List<Coach> coaches;

    private CoachGroup(List<Coach> coaches) {
        validateGroup(coaches);
        this.coaches = coaches;
    }

    public static CoachGroup from(List<Coach> coaches) {
        return new CoachGroup(coaches);
    }

    private void validateGroup(List<Coach> coaches) {
        if (isDuplicateName(coaches)) {
            throw new IllegalArgumentException(ErrorMessage.COACH_NAME_DUPLICATE.getMessage());
        }
        if (isOutOfRange(coaches)) {
            throw new IllegalArgumentException(ErrorMessage.COACH_GROUP_OUT_OF_RANGE.getMessage());
        }
    }

    private boolean isOutOfRange(List<Coach> coaches) {
        return (coaches.size() < 2) || (coaches.size() > 5);
    }

    private boolean isDuplicateName(List<Coach> coaches) {
        long distinct = coaches.stream()
                .map(Coach::getName)
                .distinct().count();

        return coaches.size() != distinct;
    }

    public int size() {
        return coaches.size();
    }

    public Coach get(int index) {
        return coaches.get(index);
    }

    public String toMessage() {
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        coaches.stream()
                .map(Coach::toMessage)
                .forEach(joiner::add);
        return joiner.toString();
    }
}
