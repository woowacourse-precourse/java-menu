package menu;

public enum CategoryIndex {
	MIN_CATEGORY_INDEX(1), MAX_CATEGORY_INDEX(5);

	private int index;

	CategoryIndex(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}
}
