package menu.domain;

import java.util.ArrayList;
import java.util.Map;

public class Ban {
    private Map<String, ArrayList<String>> banResults;

    public Ban(Map<String, ArrayList<String>> banResults) {
        this.banResults = banResults;
    }

    public boolean isBanMenu(String coach, String menu) {
        for (String banMenu : banResults.get(coach)) {
            if (banMenu.equals(menu)) {
                return true;
            }
        }
        return false;
    }
}
