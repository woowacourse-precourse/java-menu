package menu.repository;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Couch;

public class CouchRepository {
    private final List<Couch> couches = new ArrayList<>();

    public void saveAll(List<Couch> couches) {
        this.couches.addAll(couches);
    }

    public List<Couch> findAll() {
        return List.copyOf(couches);
    }
}
