package menu.dto;

import java.util.Objects;

public class CouchMenu {
    private String couchName;
    private String menuName;

    public CouchMenu(String couchName, String menuName) {
        this.couchName = couchName;
        this.menuName = menuName;
    }

    public String getCouchName() {
        return couchName;
    }

    public String getMenuName() {
        return menuName;
    }

    public boolean isCouchNameMatch(String couchName) {
        return Objects.equals(this.couchName, couchName);
    }
}
