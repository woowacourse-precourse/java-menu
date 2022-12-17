package menu.domain;

import menu.exception.InputException;

import java.util.*;

public class Coach {
    private final String name;
    private final Set<String> avoidList = new HashSet<>();
    private final List<String> recommended = new ArrayList<>();

    public Coach(String name) {
        validateNickname(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<String> getRecommended() {
        return recommended;
    }

    /**
     * 도메인 로직
     */
    public void addAvoidance(String input) {
        avoidList.clear();

        StringTokenizer st = new StringTokenizer(input, ",");
        while (st.hasMoreTokens())
            avoidList.add(st.nextToken());
    }

    public boolean addRecommended(String menu) {
        if(avoidList.contains(menu) || recommended.contains(menu))
            return false;

        recommended.add(menu);
        return true;
    }

    private void validateNickname(String name) {
        if(name.length()<2 || 4<name.length())
            throw new IllegalArgumentException(InputException.INVALID_NAME_LENGTH.getMessage());
    }
}
