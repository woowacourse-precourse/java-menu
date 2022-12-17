package menu.dto;

import java.util.List;

public class CompleteMenuDto {

    private final String name;

    private final List<String> completeMenus;

    public CompleteMenuDto(String name, List<String> completeMenus) {
        this.name = name;
        this.completeMenus = completeMenus;
    }

    public String getName() {
        return name;
    }

    public List<String> getCompleteMenus() {
        return completeMenus;
    }
}
