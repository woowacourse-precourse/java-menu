package menu.domain;

import menu.util.EnumUtil;

import java.util.List;

public enum DomainCondition implements EnumUtil {
    MIN_COACH_COUNT(2)
    , MAX_COACH_COUNT(5)
    , MIN_COACH_NAME_LENGTH(2)
    , NAX_COACH_NAME_LENGTH(4)
    , MIN_FOOD_COUNT(0)
    , MAX_FOOD_COUNT(2)
    ;

    private final int number;

    DomainCondition(int number) {
        this.number = number;
    }

    public static boolean validCoachCount(List<String> coachNames) {
        return (MIN_COACH_COUNT.number <= coachNames.size())
                && (coachNames.size() <= MAX_COACH_COUNT.number);
    }

    public static boolean validCoachNameLength(String coachName) {
        return (MIN_COACH_NAME_LENGTH.number <= coachName.length())
                && (coachName.length() <= NAX_COACH_NAME_LENGTH.number);
    }

    public static boolean validFoodCount(List<String> foodName) {
        return (MIN_FOOD_COUNT.number <= foodName.size())
                 && (foodName.size() <= MAX_FOOD_COUNT.number);
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
