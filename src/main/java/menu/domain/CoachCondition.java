package menu.domain;

import menu.util.EnumUtil;

public enum CoachCondition implements EnumUtil {
    MIN_COACH_COUNT(2)
    , MAX_COACH_COUNT(5)
    , MIN_COACH_NAME_LENGTH(2)
    , NAX_COACH_NAME_LENGTH(4)
    ;

    private final int number;

    CoachCondition(int number) {
        this.number = number;
    }

    public static boolean validCoachCount(String[] coachNames) {
        return (MIN_COACH_COUNT.number <= coachNames.length)
                && (coachNames.length <= MAX_COACH_COUNT.number);
    }

    public static boolean validCoachNameLength(String coachName) {
        return (MIN_COACH_NAME_LENGTH.number <= coachName.length())
                && (coachName.length() <= NAX_COACH_NAME_LENGTH.number);
    }

    @Override
    public String getKey() {
        return name();
    }

    @Override
    public Integer getValue() {
        return number;
    }
}
