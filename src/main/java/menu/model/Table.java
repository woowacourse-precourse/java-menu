package menu.model;

public enum Table {
    START("[ "),
    DELIMITER(" | "),
    END(" ]"),
    DAY("구분"),
    CATEGORY("카테고리");

    private final String sign;

    Table(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return this.sign;
    }
}
