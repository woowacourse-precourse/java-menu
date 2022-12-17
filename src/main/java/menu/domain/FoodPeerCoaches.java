package menu.domain;

import java.util.List;

public class FoodPeerCoaches {

    public static final int MIN_MEMBER = 2;
    public static final int MAX_MEMBER = 5;

    private final List<Coach> coaches;

    public FoodPeerCoaches(List<Coach> coaches) {
        checkCouchCount(coaches);
        this.coaches = coaches;
    }

    private void checkCouchCount(List<Coach> couchData) {
        if (couchData.size() < MIN_MEMBER) {
            throw new IllegalArgumentException("[ERROR] 같이 밥을 먹는 코치는 최소 2명이상 입니다.");
        }

        if (couchData.size() > MAX_MEMBER) {
            throw new IllegalArgumentException("[ERROR] 같이 밥을 먹는 코치는 최대 5명이하 입니다.");
        }
    }
}
