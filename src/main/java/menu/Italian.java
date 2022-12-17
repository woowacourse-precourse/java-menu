package menu;

public enum Italian {
	ONE("라자냐"), TWO("그라탱"), THREE("뇨끼"), FOUR("끼슈"),
	FIVE("프렌치 토스트"), SIX("바게트"), SEVEN("스파게티"), EIGHT("피자"), NINE("파니니");

	private String menu;

	Italian(String menu) {
		this.menu = menu;
	}

	public String getMenu() {
		return menu;
	}
}
