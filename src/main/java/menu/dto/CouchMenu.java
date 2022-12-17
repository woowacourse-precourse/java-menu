package menu.dto;

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
}
