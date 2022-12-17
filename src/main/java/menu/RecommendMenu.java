package menu;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RecommendMenu {
	
	private ArrayList<String> coachName;
	private LinkedHashMap<String, ArrayList<String>> notEatingMenuForEachCoach;
	private ArrayList<String> categoryForWeek = new ArrayList<>();
	private ArrayList<String[]> menu = new ArrayList<>();
	private LinkedHashMap<String, ArrayList<String>> result = new LinkedHashMap<>();
	private ArrayList<String> recommendedMenu;
	
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
	
	public void recommendProcess() {
		pickCategoryForAWeek();
		pickRandomFood();
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
		recommendedMenu = new ArrayList<>();
		String category = "";
		int indexOfCategory = 0;
		String food = "";
		for(int i = 0; i < categoryForWeek.size(); i++) {
			category = categoryForWeek.get(i);
			indexOfCategory = findCategoryIndex(category);
			pickRandomFoodForEachCategoryForPerson(indexOfCategory);
			recommendedMenu.add(food);
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
	
	public void pickRandomFoodForEachCategoryForPerson(int indexOfCategory) {	
		String food = "";
		for(int person = 0; person < coachName.size(); person++) {
			food = checkIfNotEatingFood(person, indexOfCategory);
			ArrayList<String> thisMenu = result.getOrDefault(coachName.get(person), new ArrayList<>());
			thisMenu.add(food);
			result.put(coachName.get(person), thisMenu);
		}	
	}
	
	
	
	public String checkIfNotEatingFood(int person, int indexOfCategory) {
		String food = "";
		ArrayList<String> notEatingMenu = notEatingMenuForEachCoach.get(coachName.get(person));
		ArrayList<String> thisMenu = changeStringArrToList(menu.get(indexOfCategory));
		while(true) {
			thisMenu = new ArrayList<>(Randoms.shuffle(thisMenu));
			food = thisMenu.get(0);
			if(!notEatingMenu.contains(food) && !checkIfDuplicatedFood(food)) {
				return food;
			}
		}
	}
	
	public ArrayList<String> changeStringArrToList(String[] menu){
		ArrayList<String> thisMenu = new ArrayList<>();
		for(int i = 0; i < menu.length; i++) {
			thisMenu.add(menu[i]);
		}
		return thisMenu;
	}
	
	public boolean checkIfDuplicatedFood(String food) {
		if(recommendedMenu.contains(food)) {
			return true;
		}
		return false;
	}
	
	public ArrayList<String> getCategoryForWeek(){
		return categoryForWeek;
	}
	
	public LinkedHashMap<String, ArrayList<String>> getResult(){
		return result;
	}
	
	public ArrayList<String> getCoachName(){
		return coachName;
	}
}
