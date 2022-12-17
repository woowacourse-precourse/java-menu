package menu.domain;

import java.util.List;

public class RandomMenu {
    private String category;

    public void select(Human human, List<String> categories) {
        for (int day = 0; day < 5; day++) {
            category = categories.get(day);
            KindAndFood kindAndFood = new KindAndFood();
            inputKindAndFood(kindAndFood, human);
            human.addKineAndFood(kindAndFood);
        }
    }

    public void inputKindAndFood(KindAndFood kindAndFood, Human human) {
        while (true) {
            inputKind(kindAndFood, human);
            break;
        }
    }

    private void inputKind(KindAndFood kindAndFood, Human human) {
        human.addCategory(kindAndFood, category);

        while (true) {
            String food = Category.recommendFood(category);
            if (human.canInputFood(food)) {
                inputFood(kindAndFood, human, food);
                break;
            }
        }
    }

    private void inputFood(KindAndFood kindAndFood, Human human, String food) {
        Food inputFood = new Food(food);
        human.addFood(kindAndFood, inputFood);
    }
}
