package menu.domain;

import java.util.*;

public class CouchRepository {
    private static final List<Couch> couches = new ArrayList<>();

    public static List<Couch> couches() {
        return Collections.unmodifiableList(couches);
    }

    public static void addCouch(Couch couch) {
        couches.add(couch);
    }

    public static Couch getCouchByName(String name) {
        Optional<Couch> first = couches().stream().filter(couch -> couch.getName().equals(name)).findFirst();
        return first.orElse(null);
    }
}
