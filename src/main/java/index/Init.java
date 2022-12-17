package index;

public enum Init {
	INIT(0),INIT_CATEGORY_COUNT_SIZE(6);

	private int index;

	Init(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}
}
