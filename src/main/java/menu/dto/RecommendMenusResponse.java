package menu.dto;

import java.util.List;

public class RecommendMenusResponse {
    private String couchName;
    private List<String> menus;

    public RecommendMenusResponse(String couchName, List<String> menus) {
        this.couchName = couchName;
        this.menus = menus;
    }

    public String getCouchName() {
        return couchName;
    }

    public List<String> getMenus() {
        return menus;
    }
}
