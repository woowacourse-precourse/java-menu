package menu.domain.category;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import menu.domain.food.AsiaFood;
import menu.domain.food.ChinaFood;
import menu.domain.food.Food;
import menu.domain.food.KoreanFood;
import menu.domain.food.WesternFood;

public enum Category {

	JAPAN_CATEGORY("일식", 1, new AsiaFood()),
	KOREAN_CATEGORY("한식", 2, new KoreanFood()),
	CHINA_CATEGORY("중식", 3, new ChinaFood()),
	ASIA_CATEGORY("아시안", 4, new AsiaFood()),
	WESTERN_FOOD("양식", 5, new WesternFood());
	private String categoryName;
	private int index;
	private Food food;

	Category(String categoryName, int index, Food food) {
		this.categoryName = categoryName;
		this.index = index;
		this.food = food;
	}


	public static Category findCategoryNameByIndex(int index) {
		return Arrays.stream(values())
				.filter(category -> category.index == index)
				.findAny()
				.orElseThrow(NoSuchElementException::new);
	}

	public static List<String> getFoodsByCategory(Category category) {
		return Arrays.stream(values())
				.filter(categorys -> categorys.equals(category))
				.findAny()
				.orElseThrow(NoSuchElementException::new)
				.getFood()
				.getFoods();
	}

	public Food getFood() {
		return food;
	}
	public String getCategoryName() {
		return categoryName;
	}

}
