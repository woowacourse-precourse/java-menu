package menu.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import menu.domain.Weekend;

public class WeekendRepository {

    private static final List<Weekend> weekends = new ArrayList<>();

    static {
        weekends.add(new Weekend("월요일"));
        weekends.add(new Weekend("화요일"));
        weekends.add(new Weekend("수요일"));
        weekends.add(new Weekend("목요일"));
        weekends.add(new Weekend("금요일"));

    }

    public static List<Weekend> weekends() {
        return Collections.unmodifiableList(weekends);
    }

    public static Weekend findByName(String dayOfWeek) {
        return weekends().stream()
            .filter(day -> day.equals(dayOfWeek))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 요일입니다."));
    }
}
