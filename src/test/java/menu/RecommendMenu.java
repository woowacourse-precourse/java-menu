package menu;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import camp.nextstep.edu.missionutils.Randoms;

public class RecommendMenu {
	
	ArrayList<String> coachName;
	LinkedHashMap<String, ArrayList<String>> notEatingMenuForEachCoach;
	ArrayList<String> categoryForWeek = new ArrayList<>();
	ArrayList<String[]> menu = new ArrayList<>();
	
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
		menu.add(new String[0]);
		menu.add(new String[] {"규동","우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"});
		menu.add(new String[] { "김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"});
		menu.add(new String[] { "깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"});
		menu.add(new String[] { "팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"});
		menu.add(new String[] { "라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"});
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
	
	public void pickRandomFood() {
		for(int person = 0; person < coachName.size(); person++) {
			
		}
	}
	
	public void pickRandomFoodForEachCategoryForPerson() {
		String category = "";
		int indexOfCategory = 0;
		int randFoodIndex = 0;
		for(int i = 0; i < categoryForWeek.size(); i++) {
			category = categoryForWeek.get(i);
			indexOfCategory = findCategoryIndex(category);
			randFoodIndex = Randoms.pickNumberInRange(0, menu.get(indexOfCategory).length - 1);
			
		}
	}
	
	public int findCategoryIndex(String category) {
		int categoryindex = 0;
		for(categories c : categories.values()) {
			if(c.getCategory().equals(category)) {
				categoryindex = c.getValue();
			}
		}
		return categoryindex;
	}
	
	public void checkIfNotEatingFood(int person, int indexOfCategory, int randFoodIndex) {
		String food = "";
		food = menu.get(indexOfCategory)[randFoodIndex];
		
	}
	
}
