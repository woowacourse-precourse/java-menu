package menu;

public enum Japan {
	ONE("규동"), TWO("우동"), THREE("미소시루"), FOUR("스시"),
	FIVE("가츠동"), SIX("오니기리"), SEVEN("하이라이스"), EIGHT("라멘"), NINE("오코노미야끼");

	private String menu;

	Japan(String menu) {
		this.menu = menu;
	}

	public String getMenu() {
		return menu;
	}
}
