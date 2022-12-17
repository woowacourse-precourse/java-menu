package menu;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class OutputView {
	ArrayList<String> categoryForWeek = new ArrayList<>();
	LinkedHashMap<String, ArrayList<String>> result = new LinkedHashMap<>();
	ArrayList<String> coachName = new ArrayList<>();
	
	public OutputView(ArrayList<String> coachName, ArrayList<String> categoryForWeek, LinkedHashMap<String, ArrayList<String>> result){
		this.categoryForWeek = categoryForWeek;
		this.result = result;
		this.coachName = coachName;
	}
	
	public void printResult() {
		printRecommendInstruction();
		printPickedCategory();
		printEachPersonResult();
		printRecommendFinish();
	}
	
	public void printRecommendInstruction() {
		System.out.println("메뉴 추천 결과입니다.");
		System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
	}
	
	public void printPickedCategory() {
		System.out.print("[ 카테고리 ");
		for(int i = 0; i < categoryForWeek.size(); i++) {
			System.out.printf("| %s ", categoryForWeek.get(i));
		}
		System.out.println("]");
	}
	
	public void printEachPersonResult() {
		for(int person = 0; person < result.size(); person++) {
			System.out.printf("[ %s ", coachName.get(person));
			ArrayList<String> eachMenu = result.get(person);
			printEachPersonMenu(eachMenu);
		}
	}
	
	public void printEachPersonMenu(ArrayList<String> eachMenu) {
		for(int menuIndex = 0; menuIndex < eachMenu.size(); menuIndex++) {
			System.out.printf("| %s ", eachMenu.get(menuIndex));
		}
		System.out.println("]");
	}
	
	public void printRecommendFinish() {
		System.out.println("추천을 완료했습니다.");
	}
}
