package menu.model;

import java.util.List;

public enum Category {

	JAPANESE_FOOD("일식", 1, List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
	KOREAN_FOOD("한식", 2, List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
	CHINESE_FOOD("중식", 3, List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
	ASIAN_FOOD("아시안", 4, List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
	WESTERN_FOOD("양식", 5, List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));

	private final String categoryName;
	private final int menuNumber;
	private final List<String> menus;

	Category(String categoryName, int menuNumber, List<String> menus) {
		this.categoryName = categoryName;
		this.menuNumber = menuNumber;
		this.menus = menus;
	}

	public static Category getCategory(int menuNumber) {
		for (Category category : Category.values()) {
			if (category.menuNumber == menuNumber) {
				return category;
			}
		}

		//TODO : 잘못된 번호가 입력됬을 경우 에러 발생
		return null;
	}

	public List<String> getMenus() {
		return this.menus;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

}
