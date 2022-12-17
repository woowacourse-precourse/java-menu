package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	ArrayList<String> coachName;
	public void askCoachName() {
		boolean checkPass = false;
		while(!checkPass) {
			System.out.println("코치의 이름을 입력해 주세요. (, 로 구분");
			String coachNames = "";
			coachNames = Console.readLine();
			if(checkPass = errorCatchForCoachName(coachNames)) {
				coachName = new ArrayList<>(List.of(coachNames));
			}
		}
	}
	
	public boolean errorCatchForCoachName(String coachNames) {
		String[] coachStr;
		try {
			checkCoachNameFormat(coachNames);
			coachStr = checkEachCoachNameLength(coachNames);
			checkCoachNameLength(coachStr);
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	public boolean checkCoachNameFormat(String coachNames) {
		String pattern = "^.+,.+$";
		if(Pattern.matches(pattern, coachNames)) {		
			return true;
		}
		throw new IllegalArgumentException("[ERROaR] 2명 이상 5명 이하의 이름을 ,로 구분지어 입력하세요.");
	}
	
	public String[] checkEachCoachNameLength(String coachNames) {
		String[] coachStr = coachNames.split(",");
		for(String coachName : coachStr) {
			if(coachName.length() < 2 && coachName.length() > 4) {
				throw new IllegalArgumentException("[ERROR] 이름이 2-4글자가 아닙니다.");
			}
		}
		return coachStr;
	}
	
	public boolean checkCoachNameLength(String[] coachStr) {
		if(coachStr.length < 2 || coachStr.length > 5) {
			throw new IllegalArgumentException("[ERROR] 코치의 수가 2-5명이 아닙니다.");
		}
		return true;
	}
	
	public void askNotEatingMenu() {
		
	}
}
