package menu.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnavailableMenuDTO {

    private String unavailableMenus;

    public UnavailableMenuDTO(String unavailableMenus) {
        this.unavailableMenus = unavailableMenus;
    }

    public List<String> getUnavailableMenus() {
        String[] menus = unavailableMenus.split("\\s*,\\s*");
        return new ArrayList<>(Arrays.asList(menus));
    }
}
