package menu;

import java.util.ArrayList;
import java.util.List;

public class Category {
	List<String> categories = new ArrayList<>();

	public void settingCategorys() {
		categories.add("일식");
		categories.add("한식");
		categories.add("중식");
		categories.add("아시안");
		categories.add("양식");
	}

	public int getCategoriesCount() {
		return categories.size();
	}

	public String getCategory(int index) {
		return categories.get(index);
	}

}
