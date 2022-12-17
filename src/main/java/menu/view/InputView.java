package menu.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import menu.handler.check.CheckHandler;
import menu.model.Coach;

public class InputView {

	private static final InputView instance = new InputView();

	private final CheckHandler checkHandler = CheckHandler.getInstance();

	private InputView() {
	}

	public static InputView getInstance() {
		return instance;
	}

	public List<Coach> readCoachNames() {
		Message.printMessage(Message.INPUT_COACH_NAMES);
		String[] coaches = setCoaches();
		validationCoachesArray(coaches);
		return arrayToList(coaches);
	}

	public void readNotEatFood(Coach coach) {
		Message.printNotEatFoodMessage(coach.getName());
		String[] notEatFood = Console.readLine().split(",");
		checkHandler.isNotEatFoodNumbers(notEatFood);
		if (notEatFood.length != 0) {
			coach.setNotEatFoodList(new ArrayList<>(Arrays.asList(notEatFood)));
			return;
		}
		coach.setNotEatFoodList(new ArrayList<>());
	}

	private void validationCoachesArray(String[] coaches) {
		checkHandler.isCoachesName(coaches);
		checkHandler.isCoachesNumbers(coaches);
	}

	private String[] setCoaches() {
		String input = Console.readLine();
		checkHandler.isCollect(input);
		return input.split(",");
	}

	private static List<Coach> arrayToList(String[] coaches) {
		List<Coach> coachList = new ArrayList<>();
		for (int i = 0; i < coaches.length; i++) {
			coachList.add(new Coach(coaches[i]));
		}
		return coachList;
	}

}
