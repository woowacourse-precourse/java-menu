package menu;

import java.util.ArrayList;
import java.util.List;

public enum Category {
	ASIAN(createAsian()),
	CHINA(createChina()),
	ITALIAN(createItalian()),
	JAPAN(createJapan()),
	KOREA(createKorea());

	private List<String> menus;

	Category(List<String> menus) {
		this.menus = menus;
	}

	public List<String> getMenus() {
		return menus;
	}

	public static List<String> getMenus(String category) {
		if (category.equals("일식")) {
			return JAPAN.getMenus();
		}
		if (category.equals("한식")) {
			return KOREA.getMenus();
		}
		if (category.equals("중식")) {
			return CHINA.getMenus();
		}
		if (category.equals("아시안")) {
			return ASIAN.getMenus();
		}

		return ITALIAN.getMenus();
	}

	public static String getCategoryName(int categoryNumber) {
		if (categoryNumber == CategoryIndex.JAPAN_INDEX.getIndex()) {
			return "일식";
		}
		if (categoryNumber == CategoryIndex.KOREA_INDEX.getIndex()) {
			return "한식";
		}
		if (categoryNumber == CategoryIndex.CHINA_INDEX.getIndex()) {
			return "중식";
		}
		if (categoryNumber == CategoryIndex.ASIAN_INDEX.getIndex()) {
			return "아시안";
		}

		return "양식";
	}

	public static List<String> createJapan() {
		List<String> list = new ArrayList<>();
		list.add("규동");
		list.add("우동");
		list.add("미소시루");
		list.add("스시");
		list.add("가츠동");
		list.add("오니기리");
		list.add("하이라이스");
		list.add("라멘");
		list.add("오코노미야끼");

		return list;
	}

	public static List<String> createChina() {
		List<String> list = new ArrayList<>();
		list.add("깐풍기");
		list.add("볶음면");
		list.add("동파육");
		list.add("짜장면");
		list.add("짬뽕");
		list.add("마파두부");
		list.add("탕수육");
		list.add("토마토 달걀볶음");
		list.add("고추잡채");

		return list;
	}

	public static List<String> createItalian() {
		List<String> list = new ArrayList<>();
		list.add("라자냐");
		list.add("그라탱");
		list.add("뇨끼");
		list.add("끼슈");
		list.add("프렌치 토스트");
		list.add("바게트");
		list.add("스파게티");
		list.add("피자");
		list.add("파니니");

		return list;
	}

	public static List<String> createAsian() {
		List<String> list = new ArrayList<>();
		list.add("팟타이");
		list.add("카오 팟");
		list.add("나시고렝");
		list.add("파인애플 볶음밥");
		list.add("쌀국수");
		list.add("똠얌꿍");
		list.add("반미");
		list.add("월남쌈");
		list.add("분짜");

		return list;
	}

	public static List<String> createKorea() {
		List<String> list = new ArrayList<>();
		list.add("김밥");
		list.add("김치찌개");
		list.add("쌈밥");
		list.add("된장찌개");
		list.add("비빔밥");
		list.add("칼국수");
		list.add("불고기");
		list.add("떡볶이");
		list.add("제육볶음");

		return list;
	}
}
