package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coaches {
    private static final int COACHES_MINIMUM_SIZE = 2;
    private static final int COACHES_MAXIMUM_SIZE = 5;
    private static final String COACHES_MINIMUM_SIZE_ERROR = "코치는 최소 2명 이상 입력해야 합니다.";
    private static final String COACHES_MAXIMUM_SIZE_ERROR = "코치는 최대 5명 까지만 입력해야 합니다.";

    private final List<Coach> coaches = new ArrayList<>();

    public Coaches(List<String> coachNames){
        validateCoachNames(coachNames);
        initCoaches(coachNames);
    }

    private void validateCoachNames(List<String> coachNames){
        if(coachNames.size()<COACHES_MINIMUM_SIZE){
            throw new IllegalArgumentException(COACHES_MINIMUM_SIZE_ERROR);
        }
        if(coachNames.size()>COACHES_MAXIMUM_SIZE){
            throw new IllegalArgumentException(COACHES_MAXIMUM_SIZE_ERROR);
        }
    }

    public void initCoaches(List<String> coachNames){
        for(String name : coachNames){
            coaches.add(new Coach(name));
        }
    }
}
