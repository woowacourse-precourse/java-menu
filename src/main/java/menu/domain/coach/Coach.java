package menu.domain.coach;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Food;
import menu.domain.exceptions.WrongFoodNumberException;
import menu.domain.exceptions.WrongNameException;
import menu.utils.Constants;

public class Coach {

    private final String name;
    private final List<Food> unEatables;

    public Coach(String name) {
        validationOfName(name);

        this.name = name;
        this.unEatables = new ArrayList<>();
    }

    private void validationOfName(String name) {
        long count = name.length();

        if (Constants.MIN_COACH_NAME_LEN > count || count > Constants.MAX_COACH_NAME_LEN) {
            throw new WrongNameException();
        }
    }

    public void addUnEatable(String foods) {
        String[] names = foods.split(",");
        for (String name : names) {
            this.unEatables.add(new Food(name));
            validationOfUnEatables(unEatables);
        }
    }

    private void validationOfUnEatables(List<Food> unEatables) {
        if (unEatables.size() > Constants.MAX_UNEATABLE_LEN) {
            throw new WrongFoodNumberException();
        }
    }

    public String getName() {
        return name;
    }

    public boolean isUnEatables(String food) {
        return unEatables.contains(food);
    }
}


