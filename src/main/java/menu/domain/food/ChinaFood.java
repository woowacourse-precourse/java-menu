package menu.domain.food;

import java.util.ArrayList;
import java.util.List;

public class ChinaFood implements Food {
	private static final String FOOD = "깐풍기,볶음면,동파육,짜장면,짬뽕,마파두부,탕수육,토마토 달걀볶음,고추잡채";
	private static final String DETERMINE = ",";

	private List<String> foods;

	public ChinaFood() {
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
