package menu.repository;

import menu.domain.Menu;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MenuRepository {
    private final AtomicLong sequence = new AtomicLong(0L);

    private final Map<Long, Menu> menuStorage = new ConcurrentHashMap<>();


    public void saveMenu(Menu menu) {
        menuStorage.put(sequence.addAndGet(1), menu);
    }
}
