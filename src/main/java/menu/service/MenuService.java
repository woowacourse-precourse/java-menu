package menu.service;

import java.util.ArrayList;
import java.util.List;

import menu.model.Category;
import menu.model.Coach;
import menu.repository.MenuRepository;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuService {

	private final MenuRepository menuRepository = MenuRepository.getInstance();
	private final InputView inputView = InputView.getInstance();
	private final OutputView outputView = OutputView.getInstance();

	private static final MenuService instance = new MenuService();

	private MenuService() {
	}

	public static MenuService getInstance() {
		return instance;
	}

	public void startService() {
		outputView.printServiceStart();
	}

	public void finishService(List<Coach> coachList) {
		outputView.recommendMenuPrint(coachList);
	}

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
	public void recommendCategory(List<Coach> coachList) {
		//카테고리를 하나 가져와서
		//1. coach에 같은 카테고리가 2개 이상 존재할 경우, 카테고리 다시 가져옴
		List<Category> categories = setCategories();
		for (Coach coach : coachList) {
			coach.setCategoryList(categories);
		}
	}

	public void recommendFood(List<Coach> coachList) {
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
			setFood(coach, category);
		}
	}

	private void setFood(Coach coach, Category category) {
		boolean state = true;
		while (state) {
			state = coach.setRecommendFood(menuRepository.getRandomMenuInCategory(category));
		}
	}

	private List<Category> setCategories() {
		List<Category> categories = new ArrayList<>();
		while (categories.size() < 5) {
			Category randomCategory = menuRepository.getRandomCategory();
			int duplicateCount = getDuplicateCount(categories, randomCategory);
			if (duplicateCount < 2) {
				categories.add(randomCategory);
			}
		}
		return categories;
	}

	private static int getDuplicateCount(List<Category> categories, Category randomCategory) {
		int duplicateCount = 0;
		for (Category getCategory : categories) {
			if (getCategory.equals(randomCategory)) {
				duplicateCount++;
			}
		}
		return duplicateCount;
	}

}
