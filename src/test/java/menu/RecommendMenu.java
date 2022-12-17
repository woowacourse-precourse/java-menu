package menu;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import camp.nextstep.edu.missionutils.Randoms;

public class RecommendMenu {
	
	ArrayList<String> coachName;
	LinkedHashMap<String, ArrayList<String>> notEatingMenuForEachCoach;
	
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
		System.out.println("[ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]");
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
