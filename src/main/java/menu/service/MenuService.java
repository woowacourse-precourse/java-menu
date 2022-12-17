package menu.service;

import menu.domain.Coach;
import menu.exception.InputException;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MenuService {
    private final List<Coach> coaches = new ArrayList<>();

    public void getCoachesName(String input) {
        int count = validateCountOfCoaches(input);

        StringTokenizer st = new StringTokenizer(input, ",");
        while (st.hasMoreTokens())
            coaches.add(new Coach(st.nextToken()));
    }

    public int validateCountOfCoaches(String input) {
        StringTokenizer st = new StringTokenizer(input, ",");
        if(st.countTokens()<2 || 5<st.countTokens())
            throw new IllegalArgumentException(InputException.INVALID_COUNT_OF_COACHES.getMessage());

        return st.countTokens();
    }
}
