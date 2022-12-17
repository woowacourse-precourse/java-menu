package menu.controller;

import java.util.List;

import menu.domain.Coach;
import menu.domain.Menu;
import menu.repository.CoachRepository;
import menu.repository.CoachUnableMenuRepository;
import menu.service.RecommendService;
import menu.view.InputView;
import menu.view.OutputView;

public class MainController {

	public void run() {
		while (true) {
			try {
				OutputView.printInitMsg();
				List<Coach> coaches = setCoaches();
				setUnableMenus(coaches);
				recommendMenu(coaches);
				OutputView.printResult();
				OutputView.printEndMsg();
				return;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private List<Coach> setCoaches() {
		List<Coach> coaches = InputView.readCoachNames();
		for (Coach coach : coaches) {
			CoachRepository.addCoach(coach);
		}
		return coaches;
	}

	private void setUnableMenus(List<Coach> coaches) {
		for (Coach coach : coaches) {
			List<Menu> menuList = InputView.readUnableMenus(coach);
			for (Menu menu : menuList) {
				CoachUnableMenuRepository.addUnableMenuByCoach(coach, menu);
			}
		}
	}

	private void recommendMenu(List<Coach> coaches) {
		RecommendService recommendService = new RecommendService(coaches);
		recommendService.recommend();
	}
}
