package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class CouchRepository {

    private static List<Couch> couches = new ArrayList<>();


    public static void addCouch(Couch couch) {
        couches.add(couch);
    }
}
