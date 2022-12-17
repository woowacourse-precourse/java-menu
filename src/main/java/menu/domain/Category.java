package menu.domain;

public enum Category {
    JAPAN("1", "일식"),
    KOREA("2", "한식"),
    CHINA("3", "중식"),
    ASIA("4", "아시안"),
    WEST("5", "양식");

    private final String command;
    private final String name;

    Category(String command, String name) {
        this.command = command;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "command='" + command + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
