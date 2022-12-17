package menu.domain;

import java.util.List;

public class FoodPeerCoaches {

    public static final int MIN_MEMBER = 2;
    public static final int MAX_MEMBER = 5;
    public static final String UNIQUE_COACH_NAME_ERROR_MESSAGE = "[ERROR] 코치들의 이름은 같을 수 없습니다.";
    public static final String UNDER_MIN_COACH_EXITING_ERROR_MESSAGE = "[ERROR] 같이 밥을 먹는 코치는 최소 2명이상 입니다.";
    public static final String OVER_MAX_COACH_EXITING_ERROR_MESSAGE = "[ERROR] 같이 밥을 먹는 코치는 최대 5명이하 입니다.";

    private final List<Coach> coaches;

    public FoodPeerCoaches(List<Coach> coaches) {
        checkCouchCount(coaches);
        checkCouchDuplication(coaches);
        this.coaches = coaches;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    private void checkCouchCount(List<Coach> couchData) {
        if (couchData.size() < MIN_MEMBER) {
            throw new IllegalArgumentException(UNDER_MIN_COACH_EXITING_ERROR_MESSAGE);
        }

        if (couchData.size() > MAX_MEMBER) {
            throw new IllegalArgumentException(OVER_MAX_COACH_EXITING_ERROR_MESSAGE);
        }
    }

    private void checkCouchDuplication(List<Coach> coachData) {
        long uniqueCoachNameNumber = coachData.stream().map(ch -> ch.getName()).distinct().count();
        if(coachData.size() != uniqueCoachNameNumber){
            throw new IllegalArgumentException(UNIQUE_COACH_NAME_ERROR_MESSAGE);
        }
    }
}
