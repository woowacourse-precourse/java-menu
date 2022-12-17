package menu.domain;

import java.util.Arrays;

public enum Day {
	MONDAY("1", "월요일"),
	TUESDAY("2", "화요일"),
	WEDNESDAY("3", "수요일"),
	THURSDAY("4", "목요일"),
	FRIDAY("5", "금요일");

	private final String num;
	private final String day;

	Day(final String num, final String day) {
		this.num = num;
		this.day = day;
	}

	public static Day from(int num) {
		String numString = Integer.toString(num);
		return Arrays.stream(Day.values())
			.filter(day -> day.num.equals(numString))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 요일입니다."));
	}
}
