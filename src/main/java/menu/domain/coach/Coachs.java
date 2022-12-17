package menu.domain.coach;

import java.util.ArrayList;
import java.util.List;

public class Coachs {

	private static final String ERROR_CODE = "[ERROR] ";
	private static final String POSSIBLE_COACH_COUNT_PRINT = "코치는 최소 2명, 최대 5명까지 식사를 함께할 수 있습니다";


	private static final String DETERMINE = ",";
	private static final int MIN_PERSON_COUNT = 2;
	private static final int MAX_PERSON_COUNT = 5;



	private List<Coach> coaches = new ArrayList<>();

	public void insertCoach(String coachNames) {
		String[] names = coachNames.split(DETERMINE);
		validate(names);
		for (String coachName : names) {
			coaches.add(new Coach(coachName));
		}
	}

	public void validate(String[] names) {
		isPossibleCoachCount(names.length);
	}

	public void isPossibleCoachCount(int size){
		if(size < MIN_PERSON_COUNT || size > MAX_PERSON_COUNT){
			throw new IllegalArgumentException(ERROR_CODE + POSSIBLE_COACH_COUNT_PRINT);
		}
	}

	public List<Coach> getCoaches() {
		return coaches;
	}
}
