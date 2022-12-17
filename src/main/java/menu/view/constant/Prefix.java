package menu.view.constant;

public enum Prefix {
    ERROR("[ERROR] ");

    private final String prefix;

    Prefix(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }
}
