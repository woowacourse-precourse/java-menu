package model;

import java.util.List;

public class Coaches {
    
    private static final String LESS_THAN_SIZE_EXCEPTION = "코치는 최소 2명 이상 입력해야 합니다.";
    private static final String GREATER_THAN_SIZE_EXCEPTION = "코치는 최대 5명 까지 입력해야 합니다.";
    
    private final List<Coach> coaches;
    
    public Coaches(List<Coach> coaches) {
        validSize(coaches);
        this.coaches = coaches;
    }
    
    public List<Coach> getCoaches() {
        return coaches;
    }
    
    private void validSize(List<Coach> coaches) {
        validLessThanSize(coaches);
        validGreaterThanSize(coaches);
    }
    
    private void validLessThanSize(List<Coach> coaches) {
        int coachesSize = coaches.size();
        if (coachesSize < 2) {
            throw new IllegalArgumentException(LESS_THAN_SIZE_EXCEPTION);
        }
    }
    
    private void validGreaterThanSize(List<Coach> coaches) {
        int coachesSize = coaches.size();
        if (coachesSize > 5) {
            throw new IllegalArgumentException(GREATER_THAN_SIZE_EXCEPTION);
        }
    }
}
