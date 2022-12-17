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

}
