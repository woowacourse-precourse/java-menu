package menu.domain.dto;

import java.util.List;

public class CoachRequestDto {

    private final String name;
    private final List<String> canNotEatFoods;

    public CoachRequestDto(String name, List<String> canNotEatFoods) {
        this.name = name;
        this.canNotEatFoods = canNotEatFoods;
    }

    public String getName() {
        return name;
    }

    public List<String> getCanNotEatFoods() {
        return canNotEatFoods;
    }
}
