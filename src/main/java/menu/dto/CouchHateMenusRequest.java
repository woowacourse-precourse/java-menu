package menu.dto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CouchHateMenusRequest {
    private List<String> hateMenus;

    private CouchHateMenusRequest(List<String> hateMenus) {
        this.hateMenus = hateMenus;
    }

    public static CouchHateMenusRequest of(String input) {
        if (input.equals("")) {
            return new CouchHateMenusRequest(Collections.emptyList());
        }
        String[] menus = input.split(",");
        validate(menus);
        return new CouchHateMenusRequest(Arrays.asList(menus));
    }

    private static void validate(String[] menus) {
        if (menus.length > 2) {
            throw new IllegalArgumentException("[ERROR] 못 먹는 0개에서 2개 이하여야 합니다.");
        }
        long notDuplicateCount = Arrays.stream(menus)
                .distinct()
                .count();
        if (notDuplicateCount != menus.length) {
            throw new IllegalArgumentException("[ERROR] 중복된 메뉴의 이름이 있으면 안됩니다.");
        }
    }

    public List<String> getHateMenus() {
        return hateMenus;
    }
}
