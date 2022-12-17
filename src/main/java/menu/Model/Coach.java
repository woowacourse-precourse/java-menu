package menu.Model;

import java.util.List;

public class Coach {
    private String name;
    private List<String> inedibles;
    private List<String> recommends;
    private final String INVALID_NAME = "입력된 이름이 올바르지 않습니다.";
    private final String NAME_OVER_RANGE = "입력된 이름의 길이가 올바르지 않습니다.";
    private final String INEDIBLES_OVER_RANGE = "못먹는 음식의 수가 너무 많습니다.";

    public Coach(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (!name.matches("^[ㄱ-ㅎㅏ-ㅣ가-힣]*$")) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
        if (name.length() > 4 || name.length() < 2) {
            throw new IllegalArgumentException(NAME_OVER_RANGE);
        }
    }

    public void setInedible(List<String> inedibles) {
        validateInedibles(inedibles);
        this.inedibles = inedibles;
    }

    public boolean setRecommendOrFalse(String food) {
        if (this.recommends.contains(food) || this.inedibles.contains(food))
            return false;
        this.recommends.add(food);
        return true;
    }

    private void validateInedibles(List<String> inedibles) {
        if (inedibles.size() > 2) {
            throw new IllegalArgumentException(INEDIBLES_OVER_RANGE);
        }
    }

    public List<String> getRecommends() {
        return this.recommends;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getInedibles() {
        return this.inedibles;
    }
}
