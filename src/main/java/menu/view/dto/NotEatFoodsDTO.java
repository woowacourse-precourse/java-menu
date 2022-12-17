package menu.view.dto;

import java.util.List;

public class NotEatFoodsDTO {

    private String name;
    private List<String> notEatFoods;

    public NotEatFoodsDTO(String name, List<String> notEatFoods) {
        this.name = name;
        this.notEatFoods = notEatFoods;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getNotEatFoods() {
        return this.notEatFoods;
    }

}
