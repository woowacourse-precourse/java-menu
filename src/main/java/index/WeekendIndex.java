package index;

public enum WeekendIndex {
	START_INDEX(0),END_INDEX(5);

	private int index;

	WeekendIndex(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}
}
