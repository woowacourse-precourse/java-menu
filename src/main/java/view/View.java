package view;

import java.util.List;

public class View {

	public static void showMenuRecommendGuideMessage() {
		System.out.println("점심 메뉴 추천을 시작합니다.\n");
	}

	public static void showCoachNameGuideMessage() {
		System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
	}

	public static void showHateFoodGuideMessage(String coachName) {
		System.out.println("\n"+coachName + "(이)가 못 먹는 메뉴를 입력해 주세요.");
	}

	public static void showRecommendResult(List<List<String>> menuList) {
		System.out.println("\n메뉴 추천 결과입니다.");
		System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");

		for(List<String> menus: menuList){
			System.out.print("[ ");
			for(String menu : menus){
				System.out.print(menu+" | ");
			}
			System.out.println(" ]");
		}
	}

	public static void showRecommendClearGuideMessage() {
		System.out.println("\n추천을 완료했습니다.");
	}
}
