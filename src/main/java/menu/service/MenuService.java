package menu.service;

import java.util.List;

import menu.model.Category;
import menu.model.Coach;
import menu.repository.MenuRepository;
import menu.view.InputView;

public class MenuService {

	private final MenuRepository menuRepository = MenuRepository.getInstance();
	private final InputView inputView = InputView.getInstance();

	//코치 리스트 생성 기능 - 서비스
	public List<Coach> makeCoachList() {
		List<Coach> coaches = inputView.readCoachNames();
		return coaches;
	}

	// 못먹는 음식 설정 기능 - 서비스
	public void setNotEatFood(List<Coach> coachList) {
		for (Coach coach : coachList) {
			inputView.readNotEatFood(coach);
		}
	}

	//카테고리 추천 기능 - 서비스
	public void recommendCategory(List<Coach> coachList) throws Exception {
		//카테고리를 하나 가져와서
		//1. coach에 같은 카테고리가 2개 이상 존재할 경우, 카테고리 다시 가져옴
		setCategoriesInCoach(coachList);

		//2. 가져온 카테고리에서 랜덤 음식 추출
		//3. 가져온 음식이 이미 존재하는 경우, 음식 다시 가져옴
		//4. 모든 코치에 음식 할당

		setFoodInCoach(coachList);
	}

	private void setFoodInCoach(List<Coach> coachList) {
		for (Coach coach : coachList) {
			shuffleFoodListInCategory(coach);
		}
	}

	private void shuffleFoodListInCategory(Coach coach) {
		for (Category category : coach.getCategoryList()) {
			setFood(coach, menuRepository.getRandomMenuInCategory(category));
		}
	}

	private void setFood(Coach coach, String randomMenuInCategory) {
		do {
			coach.setRecommendFood(randomMenuInCategory);
		} while (coach.isRecommendFoodListSizeFull());
	}

	private void setCategoriesInCoach(List<Coach> coachList) throws Exception {
		for (Coach coach : coachList) {
			do {
				coach.setCategory(menuRepository.getRandomCategory());
			} while (coach.isCategorySizeFull());
		}
	}

}
