package menu.domain;

import java.util.Arrays;
import java.util.List;

public enum Category {

	JAPAN("1", "일식"),
	KOREAN("2", "한식"),
	CHINESE("3", "중식"),
	ASIAN("4", "아시안"),
	WESTERN("5", "양식");

	private final String num;
	private final String name;

	Category(final String num, final String name) {
		this.num = num;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static Category from(int num) {
		String numString = Integer.toString(num);
		return Arrays.stream(Category.values())
			.filter(category -> category.num.equals(numString))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 카테고리입니다."));
	}

	public static List<Category> getAllCategories() {
		return List.of(JAPAN, KOREAN, CHINESE, ASIAN, WESTERN);
	}
}
