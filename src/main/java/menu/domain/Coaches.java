package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coaches {
    
    private static final int MINIMUM_COACHES_SIZE = 2;
    private static final int MAXIMUM_COACHES_SIZE = 5;
    private static final String INVALID_COACHES_SIZE = "코치는 최소 2명에서 최대 5명까지 입력해야 합니다.";
    
    private final List<Coach> coaches;
    
    public Coaches() {
        this.coaches = new ArrayList<>();
    }

    public void addAll(List<Coach> coaches) {
        validate(coaches);
        this.coaches.addAll(coaches);
    }

    private void validate(List<Coach> coaches) {
        if (coaches.size() < MINIMUM_COACHES_SIZE || coaches.size() > MAXIMUM_COACHES_SIZE) {
            throw new IllegalArgumentException(INVALID_COACHES_SIZE);
        }
    }

    public List<Coach> getCoaches() {
        return coaches;
    }
}
