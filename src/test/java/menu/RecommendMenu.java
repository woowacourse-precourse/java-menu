package menu;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import camp.nextstep.edu.missionutils.Randoms;

public class RecommendMenu {
	
	ArrayList<String> coachName;
	LinkedHashMap<String, ArrayList<String>> notEatingMenuForEachCoach;
	ArrayList<String> categoryForWeek = new ArrayList<>();
	
	enum categories {
		JAPANESE("일식", 1), KOREAN("한식", 2), CHINESE("중식", 3), ASIAN("아시안", 4), WESTERN("양식", 5);
		
		private final int value;
		private final String category;
		
		categories(String category, int value){
			this.category = category;
			this.value = value;
		}
		public int getValue() {
			return value;
		}
		public String getCategory() {
			return category;
		}	
	}
	
	public RecommendMenu(ArrayList<String> coachName, LinkedHashMap<String, ArrayList<String>> notEatingMenuForEachCoach ) {
		this.coachName = coachName;
		this.notEatingMenuForEachCoach = notEatingMenuForEachCoach;
	}
	
	
	public void printRecommendInstruction() {
		System.out.println("메뉴 추천 결과입니다.");
		System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
	}
	
	public void pickCategoryForAWeek() {
		String category = "";
		boolean checkPass = false;
		for(int categoryCount = 0; categoryCount < 5;) {
			category = pickRandomCategory();
			if(!(checkPass = checkCategoryDuplicated(category))) {
				continue;
			}
			categoryCount++;
		}
	}
	
	public boolean checkCategoryDuplicated(String category) {
		if(categoryForWeek.contains(category)) {
			if(categoryCheckMoreThanTwo(category) == 2) {
				return false;
			}
		}
		categoryForWeek.add(category);
		return true;
	}
	
	public int categoryCheckMoreThanTwo(String category) {
		int count = 0;
		for(String menu : categoryForWeek) {
			if(menu.equals(category)) {
				count++;
			}
		}
		return count;
	}
	
	public String pickRandomCategory() {
		String category = "";
		int randNum = Randoms.pickNumberInRange(1, 5);
		for(categories c : categories.values()) {
			if(c.getValue() == randNum) {
				category = c.getCategory();
			}
		}
		return category;
	}
	
	
}
