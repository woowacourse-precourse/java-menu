package menu.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import menu.domain.Category;
import menu.domain.Weekend;

public class WeekendRepository {

    private static final List<Weekend> weekends = new ArrayList<>();

    static {
        weekends.add(new Weekend("월요일", Category.NOTHING));
        weekends.add(new Weekend("화요일", Category.NOTHING));
        weekends.add(new Weekend("수요일", Category.NOTHING));
        weekends.add(new Weekend("목요일", Category.NOTHING));
        weekends.add(new Weekend("금요일", Category.NOTHING));

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


    public static boolean checkDuplication(List<Weekend> weekend) {
        HashMap<Category,Integer> map = new HashMap<>();
        for (Weekend day : weekend) {
            map.put(day.getCategory(), map.getOrDefault(day.getCategory(),0)+1);
        }
        for (Category category : map.keySet()) {
            if(map.get(category)>3){
                return true;
            }
        }
        return false;
    }
}
