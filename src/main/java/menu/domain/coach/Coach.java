package menu.domain.coach;

import java.util.ArrayList;
import java.util.List;

public class Coach {

	private static final String DETERMINE = ",";
	private static final String ERROR_CODE = "[ERROR] ";

	private static final String POSSIBLE_COACH_NAME_LENGTH = "코치의 이름은 최소 2글자, 최대 4글자여야 합니다";

	private static final int MIN_NAME_LENGTH = 2;
	private static final int MAX_NAME_LENGTH = 4;

	private String name;
	private List<String> recommandMenus = new ArrayList<>();
	private List<String> eatNotPossibleFood = new ArrayList<>();

	public Coach(String name) {
		validate(name);
		this.name = name;
	}

	public void validate(String name){
		int nameLength = name.length();
		if(nameLength < MIN_NAME_LENGTH || nameLength > MAX_NAME_LENGTH ){
			throw new IllegalArgumentException(ERROR_CODE + POSSIBLE_COACH_NAME_LENGTH);
		}
	}
	public void addNotAllowedFood(String foods){
		String[] food = foods.split(DETERMINE);
		for(String foodName : food){
			eatNotPossibleFood.add(foodName);
		}
	}
	public void addFood(String foodName){
		recommandMenus.add(foodName);
	}

	public String getName() {
		return name;
	}
	public boolean hasMenu(String food){
		return isAlreadyEat(food) && isNotPossibleFood(food);
	}
	public boolean isAlreadyEat(String food){
		return recommandMenus.contains(food);
	}

	public boolean isNotPossibleFood(String food){
		return eatNotPossibleFood.contains(food);
	}

	public List<String> getRecommandMenus() {
		return recommandMenus;
	}
}
