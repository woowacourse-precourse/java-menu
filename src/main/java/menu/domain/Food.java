package menu.domain;

public class Food {

    private final String name;

    public Food(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Food) {
            Food otherFood = (Food) other;
            return this.name.equals(otherFood.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
