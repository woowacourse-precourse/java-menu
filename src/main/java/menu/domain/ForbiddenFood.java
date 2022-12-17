package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class ForbiddenFood {
    private final List<String> forbiddenFoods = new ArrayList<>();

    private ForbiddenFood() {

    }

    public ForbiddenFood getForbiddenFood() {
        return SingletonHelper.INSTANCE;
    }

    private static class SingletonHelper {
        private static final ForbiddenFood INSTANCE = new ForbiddenFood();
    }

    public void saveForbiddenFood(String food) {
        forbiddenFoods.add(food);
    }

}
