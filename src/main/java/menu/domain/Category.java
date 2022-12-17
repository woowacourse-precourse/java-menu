package menu.domain;

public enum Category {

    JAPANESE_FOOD("1", "일식"),
    KOREAN_FOOD("2", "한식"),
    CHINESE_FOOD("3", "중식"),
    ASIAN_FOOD("4", "아시안"),
    AMERICAN_FOOD("5", "양식");

    private final String command;
    private final String name;

    Category(String command, String name) {
        this.command = command;
        this.name = name;
    }

    public String getCommand() {
        return command;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "[" + name + "]";
    }
}
