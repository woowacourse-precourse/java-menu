package menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import input.Input;
import view.View;

public class Application {
	//코치들 담는 List
	//코치 : 못먹는 음식, 추천 음식
	public static String[] coachNamesArr; //이거 리스트로 바꿔 그리고 이넘 사용 고려해봐
	public static List<List<String>> coachesHateFood;
	public static List<List<String>> menuRecommendResult;
	public static List<String> menuRecommend;
	public static List<Integer> categoryCount;
	public static List<String> weeklyCategory;

	public static void main(String[] args) {
		init();
		//점심 메뉴 추천을 시작합니다.
		View.showMenuRecommendGuideMessage();

		//코치의 이름을 입력해 주세요. (, 로 구분)
		View.showCoachNameGuideMessage();
		String coachNames = Input.input();
		coachNamesArr = coachNames.split(",");

		//토미(이)가 못 먹는 메뉴를 입력해 주세요.
		for (int i = 0; i < coachNamesArr.length; i++) {
			View.showHateFoodGuideMessage(coachNamesArr[i]);
			String hateFoodInput = Input.input();
			String[] hateFoodsArr = hateFoodInput.split(",");
			coachesHateFood.add(Arrays.asList(hateFoodsArr));
		}

		//메뉴 추천하기

		//카테고리 정하기
		for(int i=0;i<5;i++) {
			int categoryNumber = Randoms.pickNumberInRange(1, 5);

			//한 주에 같은 카테고리는 최대 2회까지만 고를 수 있다.
			while (categoryCount.get(categoryNumber) >= 2) {
				categoryNumber = Randoms.pickNumberInRange(1, 5);
			}

			categoryCount.set(categoryNumber, categoryCount.get(categoryNumber) + 1);
			//1이면 일식, 2면 한식, 3이면 중식, 4면 아시안, 5면 양식
			weeklyCategory.add(Category.getCategoryName(categoryNumber));
			List<String> menus = Category.getMenus(categoryNumber);
		}

		for(String category : weeklyCategory){
			System.out.println(category);
		}




		//메뉴 선택하기

		//메뉴 추천 결과 출력
		//View.showRecommendResult(menuRecommendResult);

		//메뉴 추천 완료 메세지 출력
		//View.showRecommendClearGuideMessage();
	}

	private static void init() {
		coachesHateFood = new ArrayList<>();
		weeklyCategory = new ArrayList<>();

		categoryCount = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			categoryCount.add(0);
		}
	}

	public static void recommendMenu() {

	}
}
