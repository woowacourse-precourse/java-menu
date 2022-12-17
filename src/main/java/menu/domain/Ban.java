package menu.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ban {
    private Map<String, ArrayList<String>> banResults;

    public Ban(Map<String, ArrayList<String>> banResults) {
        this.banResults = banResults;
    }
}
