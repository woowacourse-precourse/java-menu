package menu.service;

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

	public List<Coach> makeCoachList() {
		return inputView.readCoachNames();
	}

	public void setNotEatFood(List<Coach> coachList) {
		for (Coach coach : coachList) {
			inputView.readNotEatFood(coach);
		}
	}

	public void recommendFoodByCategory(List<Coach> coachList) {
		//TODO : 역할 분리
		for (int day = 0; day < 5; day++) {
			Category randomCategory = menuRepository.getRandomCategory();
			for (int i = 0; i < coachList.size(); i++) {
				if (!coachList.get(i).addCategoryList(randomCategory)) {
					i--;
					randomCategory = menuRepository.getRandomCategory();
				}
			}

			for (int i = 0; i < coachList.size(); i++) {
				String randomMenuInCategory = menuRepository.getRandomMenuInCategory(randomCategory);
				if (!coachList.get(i).addRecommendList(randomMenuInCategory)) {
					i--;
				}
			}

		}

	}
}
