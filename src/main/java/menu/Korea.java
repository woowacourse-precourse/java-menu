package menu;

public enum Korea {
	ONE("김밥"), TWO("김치찌개"), THREE("쌈밥"), FOUR("된장찌개"),
	FIVE("비빔밥"), SIX("칼국수"), SEVEN("불고기"), EIGHT("떡볶이"), NINE("제육볶음");

	private String menu;

	Korea(String menu) {
		this.menu = menu;
	}

	public String getMenu() {
		return menu;
	}
}
