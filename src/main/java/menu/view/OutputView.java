package menu.view;

import java.util.List;

import menu.model.Coach;

public class OutputView {

	public void printServiceStart() {
		Message.printMessage(Message.SERVICE_START);
	}

	// 메뉴 추천 결과 출력
	public void recommendMenuPrint(List<Coach> list) {
		Message.printFinalMessage(list);
	}

}
