package menu;

public enum Asian {
	ONE("팟타이"), TWO("카오 팟"), THREE("나시고렝"), FOUR("파인애플 볶음밥"),
	FIVE("쌀국수"), SIX("똠얌꿍"), SEVEN("반미"), EIGHT("월남쌈"), NINE("분짜");

	private String menu;

	Asian(String menu) {
		this.menu = menu;
	}

	public String getMenu() {
		return menu;
	}
}
