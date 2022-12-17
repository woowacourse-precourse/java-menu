package menu.view;

import java.util.List;

import menu.model.Category;
import menu.model.Coach;

public enum Message {
	SERVICE_START("점심 메뉴 추천을 시작합니다.\n"),
	INPUT_COACH_NAMES("코치의 이름을 입력해 주세요. (, 로 구분)"),
	INPUT_NOT_EAT_FOOD("(이)가 못 먹는 메뉴를 입력해 주세요."),
	PRINT_RECOMMEND_RESULT("메뉴 추천 결과입니다."),
	PRINT_DAYS("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"),
	SERVICE_FINISH("추천을 완료했습니다."),
	;

	private final String message;

	Message(String message) {
		this.message = message;
	}

	public static void printMessage(Message message) {
		System.out.println(message.message);
	}

	public static void printNotEatFoodMessage(String name) {
		System.out.println("\n" + name + INPUT_NOT_EAT_FOOD.message);
	}

	private static String getStringByCategoryList(Coach coach) {
		List<Category> categoryList = coach.getCategoryList();
		StringBuilder sb = new StringBuilder();
		sb.append("[ 카테고리 | ");
		for (int i = 0; i < categoryList.size() - 1; i++) {
			sb.append(categoryList.get(i).getCategoryName()).append(" | ");
		}
		sb.append(categoryList.get(categoryList.size() - 1).getCategoryName()).append(" ]").append('\n');
		return sb.toString();
	}

	public static void printFinalMessage(List<Coach> coachList) {
		StringBuilder sb = new StringBuilder();
		sb.append(PRINT_RECOMMEND_RESULT.message).append('\n');
		sb.append(PRINT_DAYS.message).append('\n');
		sb.append(getStringByCategoryList(coachList.get(0)));
		for (Coach coach : coachList) {
			sb.append(coach.getRecommendFoodList()).append('\n');
		}
		sb.append('\n').append(SERVICE_FINISH.message);
		System.out.println(sb);
	}
}
