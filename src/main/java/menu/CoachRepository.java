package menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoachRepository {
	Map<String, List<String>> coachsInformation = new HashMap<>();

	public void setCoachs(String inputCoach,List<String> inputNotEatFoods) {
		coachsInformation.put(inputCoach, inputNotEatFoods);
	}

	public int getCoachsSize() {
		return coachsInformation.size();
	}
}
