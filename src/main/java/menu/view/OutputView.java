package menu.view;

import java.util.List;

import menu.model.Coach;

public class OutputView {

	private static final OutputView instance = new OutputView();

	private OutputView() {
	}

	public static OutputView getInstance() {
		return instance;
	}

	public void printServiceStart() {
		Message.printMessage(Message.SERVICE_START);
	}

	public void recommendMenuPrint(List<Coach> list) {
		Message.printFinalMessage(list);
	}

}
