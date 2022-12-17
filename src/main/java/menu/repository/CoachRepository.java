package menu.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import menu.domain.Coach;

public class CoachRepository {

	private static final List<Coach> coaches = new ArrayList<>();

	public static List<Coach> coaches() {
		return Collections.unmodifiableList(coaches);
	}

	public static void addCoach(Coach coach) {
		coaches.add(coach);
	}

	// TODO: 이름으로 조회하나 get은 코치 객체를 반환하는 것이 일관성이 없다.
	public static Coach getCoach(String name) {
		return coaches.stream()
			.filter(coach -> coach.getName().equals(name))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 코치 이름입니다."));
	}

	public static void clear() {
		coaches.clear();
	}
}
