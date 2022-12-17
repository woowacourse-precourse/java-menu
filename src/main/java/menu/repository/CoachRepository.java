package menu.repository;

import menu.domain.Coach;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class CoachRepository {

    private final AtomicLong sequence = new AtomicLong(0L);

    private final Map<Long, Coach> coachStorage = new ConcurrentHashMap<>();


    public void saveCoach(Coach coach) {
        coachStorage.put(sequence.addAndGet(1), coach);
    }

}
