package menu.domain.food;

import java.util.ArrayList;
import java.util.List;

public class KoreanFood implements Food {

	private static final String FOOD = "김밥,김치찌개,쌈밥,된장찌개,비빔밥,칼국수,불고기,떡볶이,제육볶음";
	private static final String DETERMINE = ",";

	private List<String> foods;

	public KoreanFood() {
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
