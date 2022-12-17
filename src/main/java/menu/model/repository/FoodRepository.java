package menu.model.repository;

import menu.model.domain.Food;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodRepository {
    private Long id = 0L;
    private final Map<Long, Food> foods = new HashMap<>();

    public Long save(Food food) {
        foods.put(id, food);
        return id++;
    }

//    public Food findByName(String name) {
//        return members.values().stream()
//                .filter(member -> member.getName().equals(name))
//                .findFirst().orElse(null);
//    }
//
//    public List<Member> findAll() {
//        return new ArrayList<>(members.values());
//    }
//
//    public Member findByCourse(Course course) {
//        return members.values().stream()
//                .filter(x -> x.getCourse().equals(course))
//                .findFirst().orElse(null);
//    }
}
