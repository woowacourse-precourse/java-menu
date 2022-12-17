package menu.domain;

import java.util.Objects;

public class Food {
    private final Category category;
    private final String name;

    public Food(Category category, String name) {
        this.category = category;
        this.name = name;
    }

    public String loadName() {
        return this.name;
    }

    public boolean isJapaneseFood() {
        return category.isJapaneseFood();
    }

    public boolean isKoreanFood() {
        return category.isKoreanFood();
    }

    public boolean isChineseFood() {
        return category.isChineseFood();
    }

    public boolean isAsianFood() {
        return category.isAsianFood();
    }

    public boolean isWesternFood() {
        return category.isWesternFood();
    }

    public boolean isSame(String foodName) {
        return Objects.equals(this.name, foodName);
    }

    public boolean isSameCategory(Food food) {
        return this.category.isSame(food.category);
    }

    @Override
    public String toString() {
        return "Food{" +
                "category=" + category +
                ", name='" + name + '\'' +
                '}';
    }
}
