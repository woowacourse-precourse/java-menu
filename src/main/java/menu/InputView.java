package menu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Pattern;

import org.assertj.core.util.Arrays;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private ArrayList<String> coachName;
	private LinkedHashMap<String, ArrayList<String>> notEatingMenuForEachCoach = new LinkedHashMap<>();
	
	public void askCoachName() {
		boolean checkPass = false;
		while(!checkPass) {
			System.out.println("코치의 이름을 입력해 주세요. (, 로 구분");
			String coachNames = "";
			coachNames = Console.readLine();
			if(checkPass = errorCatchForCoachName(coachNames)) {
				coachName = splitCoachName(coachNames);
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
	
	public ArrayList<String> splitCoachName(String coachNames){
		String[] coachStr = coachNames.split(",");
		ArrayList<String> coachName = new ArrayList<>();
		for(String name : coachStr) {
			coachName.add(name);
		}
		return coachName;
	}
	
	public void askNotEatingMenu() {
		for(int coachIndex = 0; coachIndex < coachName.size(); ) {
			String notEatingMenu = "";
			System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.", coachName.get(coachIndex));
			notEatingMenu = Console.readLine();
			if(!errorCatchForNotEatingMenu(notEatingMenu)) {
				continue;
			}
			inputNotEatingMenuForEachCoach(coachIndex, notEatingMenu);
			coachIndex++;
		}
	}
	
	public boolean errorCatchForNotEatingMenu(String notEatingMenu) {
		try {
			checkMenuCount(notEatingMenu);
			checkMenuDuplicated(notEatingMenu);
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	public boolean checkMenuCount(String notEatingMenu) {
		String[] notEatingMenuStr = notEatingMenu.split(",");
		if(notEatingMenuStr.length > 2) {
			throw new IllegalArgumentException("[ERROR] 못 먹는 메뉴의 개수는 2개까지 작성 가능합니다.");
		}
		return true;
	}
	
	public void checkMenuDuplicated(String notEatingMenu) {
		String[] notEatingMenuStr = notEatingMenu.split(",");
		int originalSize = notEatingMenuStr.length;
		HashSet<String> notEatingMenuSet = new HashSet<>();
		for(String menu : notEatingMenuStr) {
			notEatingMenuSet.add(menu);
		}
		if(notEatingMenuSet.size() != originalSize) {
			throw new IllegalArgumentException("[ERROR] 못 먹는 메뉴가 중복 됩니다.");
		}
	}
	
	public void inputNotEatingMenuForEachCoach(int coachIndex, String notEatingMenu) {
		String[] notEatingMenuStr = notEatingMenu.split(",");
		notEatingMenuForEachCoach.put(coachName.get(coachIndex), new ArrayList(Arrays.asList(notEatingMenuStr)));
	}
	
	public ArrayList<String> getCoachName(){
		return coachName;
	}
	
	public LinkedHashMap<String, ArrayList<String>> getNotEatingMenuForEachCoach() {
		return notEatingMenuForEachCoach;
	}
}
