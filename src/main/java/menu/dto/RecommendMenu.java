package menu.dto;

import java.util.ArrayList;
import java.util.List;

public class RecommendMenu {
    private List<CouchMenu> couchMenus = new ArrayList<>();
    private String category;

    public RecommendMenu(String category) {
        this.category = category;
    }

    public void addCouchMenu(CouchMenu couchMenu) {
        couchMenus.add(couchMenu);
    }

    public List<CouchMenu> getCouchMenus() {
        return couchMenus;
    }

    public String getCategory() {
        return category;
    }
}
