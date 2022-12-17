package menu.domain;

import java.util.Arrays;

public enum Category {
    JAPAN("1", "일식"),
    KOREA("2", "한식"),
    CHINA("3", "중식"),
    ASIA("4", "아시안"),
    WEST("5", "양식");

    public static final String WRONG_COMMAND_VALUE = "잘못된 커맨드 입력";
    public static final int maxFrequency = 2;
    private final String command;
    private final String name;

    Category(String command, String name) {
        this.command = command;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Category findByCommand(int command) {
        return Arrays.stream(Category.values())
                .filter(category -> category.command.equals(String.valueOf(command)))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(WRONG_COMMAND_VALUE));
    }

    @Override
    public String toString() {
        return "Category{" +
                "command='" + command + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
