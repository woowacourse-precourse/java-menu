package menu.model;

public enum Category {
    JAPAN(1),
    KOREA(2),
    CHINA(3),
    ASIA(4),
    WEST(5);
    private final int country;

    Category(int country) {
        this.country = country;
    }

    public int getCountry() {
        return country;
    }
}
