package menu.handler.check;

import menu.handler.ExceptionHandler;
import menu.view.Message;

public class CheckHandler {

	private static final CheckHandler instance = new CheckHandler();

	private CheckHandler() {
	}

	public static CheckHandler getInstance() {
		return instance;
	}

	public void isCoachesName(String[] coaches) {
		for (String coach : coaches) {
			if (!(coach.length() >= 2 && coach.length() <= 4)) {
				ExceptionHandler.raisingIllegalArgumentException(
					Message.getErrorMessage(Message.ERROR_COACH_NAME_LENGTH));
			}
		}
	}

	public void isCoachesNumbers(String[] coaches) {
		if (!(coaches.length >= 2 && coaches.length <= 5)) {
			ExceptionHandler.raisingIllegalArgumentException(Message.getErrorMessage(Message.ERROR_COACH_LENGTH));
		}
	}

	public void isNotEatFoodNumbers(String[] notEatFood) {
		if (!(notEatFood.length <= 2)) {
			ExceptionHandler.raisingIllegalArgumentException(Message.getErrorMessage(Message.ERROR_FOOD_LENGTH));
		}
	}

	public void isCollect(String input) {
		if (!input.matches("^[가-힝a-zA-Z,]*$")) {
			ExceptionHandler.raisingIllegalArgumentException(Message.getErrorMessage(Message.ERROR_INPUT));
		}
	}
}
