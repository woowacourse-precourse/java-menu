package menu.dto.input;

import java.util.ArrayList;
import java.util.List;

public class ReadUnavailableMenuDto {
    private final List<String> unavailableMenus = new ArrayList<>();

    public void add(String input) {
        this.unavailableMenus.add(input);
    }

    public List<String> getUnavailableMenus() {
        return unavailableMenus;
    }
}
