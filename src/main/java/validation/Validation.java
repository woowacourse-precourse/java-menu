package validation;

import input.Input;
import view.View;

public class Validation {
	public static String validateCoachInputException(String coachInput) {
		while (isCoachInputException(coachInput)) {
			View.showCoachNameGuideMessage();
			coachInput = Input.input();
		}

		return coachInput;
	}

	public static boolean isCoachInputException(String coachInput) {
		String[] coaches = coachInput.split(",");
		try {
			validateCoachNames(coaches);
			validateCoachCount(coaches);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return true;
		}
		return false;
	}

	private static void validateCoachCount(String[] coaches) {
		if (coaches.length > 5 || coaches.length < 2) {
			throw new IllegalArgumentException("[ERROR] 코치의 인원은 2명 이상, 5명 이하로 입력해주세요. ");
		}
	}

	private static void validateCoachNames(String[] coaches) {
		for (int i = 0; i < coaches.length; i++) {
			if (coaches[i].length() < 2 || coaches[i].length() > 4) {
				throw new IllegalArgumentException("[ERROR] 코치의 이름은 2글자 이상, 최대 4글자 이하로 입력해주세요. ");
			}
		}
	}

	public static String validateHateFoodInputException(String hateFoodInput , String coachName) {
		while (isHateFoodInputException(hateFoodInput)) {
			View.showHateFoodGuideMessage(coachName);
			hateFoodInput = Input.input();
		}

		return hateFoodInput;
	}

	public static boolean isHateFoodInputException(String hateFoodInput) {
		try {
			validateHateFoodInput(hateFoodInput);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return true;
		}
		return false;
	}


	public static void validateHateFoodInput(String hateFoodInput) {
		String[] hateFoods = hateFoodInput.split(",");

		for(int index=0;index< hateFoods.length;index++){
			if(hateFoods[index].contains(".") || hateFoods[index].contains("|") || hateFoods[index].contains("#")
				|| hateFoods[index].contains("@") || hateFoods[index].contains("!") || hateFoods[index].contains("$")
				|| hateFoods[index].contains("%") || hateFoods[index].contains("^") || hateFoods[index].contains("&")
				|| hateFoods[index].contains("*") || hateFoods[index].contains("(") || hateFoods[index].contains(")") || hateFoods[index].contains("#")
				|| hateFoods[index].contains("/")){
				throw new IllegalArgumentException("[ERROR] 구분자는 ,를 이용해주세요. ");
			}
		}

		if (hateFoods.length > 2) {
			throw new IllegalArgumentException("[ERROR] 못 먹는 음식은 2개까지만 입력해주세요. ");
		}
	}
}
