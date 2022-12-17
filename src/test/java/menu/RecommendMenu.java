package menu;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class RecommendMenu {
	
	ArrayList<String> coachName;
	LinkedHashMap<String, ArrayList<String>> notEatingMenuForEachCoach;
	
	enum category {
		JAPANESE(1), KOREAN(2), CHINESE(3), ASIAN(4), WESTERN(5);
		
		private final int value;
		category(int value){
			this.value = value;
		}
		
		public int getValue() {
			return value;
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
	
	
}
