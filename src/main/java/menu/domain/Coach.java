package menu.domain;

import menu.exception.InputException;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Coach {
    private final String name;
    private final List<String> avoidList = new ArrayList<>();

    public Coach(String name) {
        validateNickname(name);
        this.name = name;
    }

    /**
     * 도메인 로직
     */
    public void addAvoidance(String input) {
        validateCountOfAvoidance(input);

        StringTokenizer st = new StringTokenizer(input, ",");
        while (st.hasMoreTokens())
            avoidList.add(st.nextToken());
    }

    private void validateCountOfAvoidance(String input) {
        int count = new StringTokenizer(input, ",").countTokens();

        if(count<0 || 2<count)
            throw new IllegalArgumentException(InputException.INVALID_COUNT_OF_AVOIDANCE.getMessage());
    }

    private void validateNickname(String name) {
        if(name.length()<2 || 4<name.length())
            throw new IllegalArgumentException(InputException.INVALID_NAME_LENGTH.getMessage());
    }
}
