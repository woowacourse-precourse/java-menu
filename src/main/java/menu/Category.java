package menu;

import java.util.ArrayList;
import java.util.List;

public class Category {
	List<String> categorys = new ArrayList<>();

	public void settingCategorys() {
		categorys.add("일식");
		categorys.add("한식");
		categorys.add("중식");
		categorys.add("아시안");
		categorys.add("양식");
	}
}
