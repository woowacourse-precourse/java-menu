package menu.domain.food;

import java.util.ArrayList;
import java.util.List;

public class WesternFood implements Food{

	private static final String FOOD = "라자냐,그라탱,뇨끼,끼슈,프렌치 토스트,바게트,스파게티,피자,파니니";
	private static final String DETERMINE = ",";

	private List<String> foods;

	public WesternFood() {
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
