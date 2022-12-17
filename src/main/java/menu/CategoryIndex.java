package menu;

public enum CategoryIndex {
	MIN_CATEGORY_INDEX(1), MAX_CATEGORY_INDEX(5),
	JAPAN_INDEX(1),KOREA_INDEX(2),CHINA_INDEX(3),
	ASIAN_INDEX(4),ITALIAN_INDEX(5);

	private int index;

	CategoryIndex(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}
}
