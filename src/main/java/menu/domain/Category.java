package menu.domain;

public enum Category {
    JAPAN(1),
    KOREA(2),
    CHINA(3),
    ASIAN(4),
    WESTERN(5);

    private final Integer command;

    Category(Integer command) {
        this.command = command;
    }
}
