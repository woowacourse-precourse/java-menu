package menu.dto;

import java.util.List;

public class CouchMenuResponse {
    private String couchName;
    private List<String> menus;

    public CouchMenuResponse(String couchName, List<String> menus) {
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
