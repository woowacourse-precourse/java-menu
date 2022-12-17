package menu.domain;

import java.util.List;

public class Human {
    public String name;
    public List<KindAndFood> kindAndFoods;
    public List<String> hateFoods;

    public Human(String name, List<KindAndFood> kindAndFoods, List<String> hateFoods) {
        this.name = name;
        this.kindAndFoods = kindAndFoods;
        this.hateFoods = hateFoods;
    }

    public boolean canInputCategory(String category) {
        int count = (int) kindAndFoods.stream()
                .filter(ele -> ele.getCategory().equals(category))
                .count();

        if (count < 2) {
            return true;
        }
        return false;
    }

    public boolean canInputFood(String food) {
        if (!isHateFood(food)) {
            int count = (int) kindAndFoods.stream()
                    .filter(ele -> ele.getFood().getFood().equals(food))
                    .count();

            if (count < 1) {
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean isHateFood(String food) {
        if (hateFoods != null && hateFoods.contains(food)) {
            return true;
        }
        return false;
    }

    public void addCategory(KindAndFood kindAndFood, String category) {
        kindAndFood.addCategory(category);
    }

    public void addFood(KindAndFood kindAndFood, Food food) {
        kindAndFood.addFood(food);
    }

    public void addKineAndFood(KindAndFood kindAndFood) {
        kindAndFoods.add(kindAndFood);
    }


    public String getName() {
        return this.name;
    }

    public List<KindAndFood> getKindAndFoods() {
        return kindAndFoods;
    }

    public List<String> getHateFoods() {
        return hateFoods;
    }


}
