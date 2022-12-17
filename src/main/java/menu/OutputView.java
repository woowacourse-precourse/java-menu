package menu;

import java.util.List;

public class OutputView {
	public void startMessage() {
		System.out.println("점심 메뉴 추천을 시작합니다.");
	}

	public void coachInputMessage() {
		System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
	}

	public void notEatFoodMessage(String coachName) {
		System.out.println(coachName+"(이)가 못 먹는 메뉴를 입력해 주세요.");
	}

	public void resultMessage() {
		System.out.println("메뉴 추천 결과입니다.");
		System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
	}

	public void resultCategory(List<String> byDayOfTheWeekSelectCategoryRepository) {
		String replaceCategory=String.join(" | ", byDayOfTheWeekSelectCategoryRepository);
		System.out.println("[ 카테고리 | "+replaceCategory+" ]");
	}

	public void resultMenu(String coachName, List<String> selectMenu) {
		String addboadselectMenu=String.join(" | ", selectMenu);
		System.out.println("[ "+coachName+" | "+addboadselectMenu+" ]");
	}

	public void endMessage() {
		System.out.println("\n추천을 완료했습니다.");
	}
}
