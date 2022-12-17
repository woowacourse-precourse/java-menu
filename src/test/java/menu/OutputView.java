package menu;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class OutputView {
	ArrayList<String> categoryForWeek = new ArrayList<>();
	LinkedHashMap<String, ArrayList<String>> result = new LinkedHashMap<>();
	
	public OutputView(ArrayList<String> categoryForWeek, LinkedHashMap<String, ArrayList<String>> result){
		this.categoryForWeek = categoryForWeek;
		this.result = result;
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
}
