package menu;

import java.util.regex.Pattern;

public class RecommendException {
	public void checkCoachsSize(int size) throws IllegalArgumentException {
		if (size < 2 || size > 5) {
			throw new IllegalArgumentException("[ERROR] 인원수는 2~5명만 입력해주세요.");
		}
	}

	public void checkCoachsNameSize(String[] splitCoach) {
		for (String coach : splitCoach) {
			if (coach.length() < 2 || coach.length() > 4) {
				throw new IllegalArgumentException("[ERROR] 이름의 길이를 2~4사이로 정해주세요.");
			}
		}
	}
	public void checkMissMatch(String[] splitCoach) throws IllegalArgumentException {
		for (String coach : splitCoach) {
			if (!Pattern.matches("^[가-힣]*$", coach)) {
				throw new IllegalArgumentException("[ERROR] 한글로 이루어져야합니다.");
			}
		}
	}

	public void checkNotEatFoodSize(int size) throws IllegalArgumentException {
		if (size > 2) {
			throw new IllegalArgumentException("[ERROR] 못먹는 음식은 2개 초과할수 없습니다.");
		}
	}

}
