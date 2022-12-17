package menu.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Coachs {

    private static final String RANGE_ERROR_MSG = "최소 2명 최대 5명 입력";
    private static final Integer MIN_SIZE_COACHS = 2;
    private static final Integer MAX_SIZE_COACHS = 5;
    private final List<Coach> coachs;

    private Coachs(List<Coach> coachs) {
        validateCoachsSize(coachs);
        this.coachs = coachs;
    }

    public static Coachs from(String coachNames){

        List<Coach> coachs = Arrays.stream(coachNames.split(","))
                .map(name -> Coach.from(name))
                .collect(Collectors.toList());

        return new Coachs(coachs);
    }

    private void validateCoachsSize(List<Coach> coachs){
        int coachsSize = coachs.size();
        if(coachsSize<MIN_SIZE_COACHS || coachsSize>MAX_SIZE_COACHS)
            throw new IllegalArgumentException(RANGE_ERROR_MSG);
    }
}
