package menu;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	ArrayList<String> coachName = new ArrayList<>();
	public void askCoachName() {
		boolean check = false;
		while(!check) {
			String coachNames = "";
			coachNames = Console.readLine();
			check = errorCatchForCoachName(coachNames);
		}
	}
	
	public boolean errorCatchForCoachName(String coachNames) {
		try {
			checkCoachNameFormat(coachNames);
			checkCoachNameLength(coachNames);
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	public boolean checkCoachNameFormat(String coachNames) {
		String pattern = "^.+,.+$";
		
	}
	
	public boolean checkCoachNameLength(String coachNames) {
		if(coachNames.length() < 2 || coachNames.length() > 5) {
			throw new IllegalArgumentException("[ERROR] 이름이 2-4글자가 아닙니다.");
		}
		return true;
	}
}
