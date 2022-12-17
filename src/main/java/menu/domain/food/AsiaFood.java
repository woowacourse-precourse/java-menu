package menu.domain.food;

import java.util.ArrayList;
import java.util.List;

public class AsiaFood implements Food {

	private static final String FOOD = "팟타이,카오 팟,나시고렝,파인애플 볶음밥,쌀국수,똠얌꿍,반미,월남쌈,분짜";
	private static final String DETERMINE = ",";

	private List<String> foods;

	public AsiaFood() {
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
