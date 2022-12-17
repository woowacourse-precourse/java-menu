package menu.dto;

import java.util.List;

public class RecommendCouchMenu {
    private String couchName;
    private List<String> menus;

    public RecommendCouchMenu(String couchName, List<String> menus) {
        this.couchName = couchName;
        this.menus = menus;
    }

    @Override
    public String toString() {
        return String.format("[ %s | %s ]", couchName, String.join(" | ", menus));
    }
}
