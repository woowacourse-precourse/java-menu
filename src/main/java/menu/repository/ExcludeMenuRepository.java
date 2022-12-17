package menu.repository;

import java.util.ArrayList;
import java.util.List;
import menu.domain.CoachExcludeMenu;

public class ExcludeMenuRepository {
    public static final int MENU_INDEX = 0;
    private static final ExcludeMenuRepository instance = new ExcludeMenuRepository();
    private static final List<CoachExcludeMenu> store = new ArrayList<>();

    private ExcludeMenuRepository() {
    }


    public static CoachExcludeMenu save(final CoachExcludeMenu coachExcludeMenu) {
        delete();
        store.add(coachExcludeMenu);
        return find();
    }

    private static CoachExcludeMenu find() {
        return store.get(MENU_INDEX);
    }

    private static void delete() {
        store.clear();
    }
}
