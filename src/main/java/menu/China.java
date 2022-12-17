package menu;

public enum China {
	ONE("깐풍기"), TWO("볶음면"), THREE("동파육"), FOUR("짜장면"),
	FIVE("짬뽕"), SIX("마파두부"), SEVEN("탕수육"), EIGHT("토마토 달걀볶음"), NINE("고추잡채");

	private String menu;

	China(String menu) {
		this.menu = menu;
	}

	public String getMenu() {
		return menu;
	}
}
