package menu.domain.food;

import java.util.ArrayList;
import java.util.List;

public class JapanFood implements Food{
	private static final String FOOD = "규동,우동,미소시루,스시,가츠동,오니기리,하이라이스,라멘,오코노미야끼";
	private static final String DETERMINE = ",";

	private List<String> foods;

	JapanFood() {
		initFood();
	}
	@Override
	public void initFood() {
		String[] foodSplit = FOOD.split(DETERMINE);
		foods = new ArrayList<>(List.of(foodSplit));
	}

	@Override
	public List<String> getFoods() {
		return foods;
	}
}
