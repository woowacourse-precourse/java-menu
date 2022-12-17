package menu.dto;

import java.util.List;
import menu.domain.Couch;

public class RecommendCouchMenu {
    private String couchName;
    private List<String> menus;

    public RecommendCouchMenu(String couchName, List<String> menus) {
        this.couchName = couchName;
        this.menus = menus;
    }

    public static RecommendCouchMenu of(Couch couch) {
        return new RecommendCouchMenu(couch.getName(), couch.getRecommendsMenus());
    }

    @Override
    public String toString() {
        return String.format("[ %s | %s ]", couchName, String.join(" | ", menus));
    }
}
