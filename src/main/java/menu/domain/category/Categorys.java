package menu.domain.category;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Categorys {

	private static final int POSSIBLE_CATEGORY_COUNT = 2;

	List<Category> categories = new ArrayList<>();

	public void insertCategory(Category category){
		categories.add(category);
	}
	public boolean canAddCategory(Category category){
		int count = Collections.frequency(categories,category);
		if(count >= POSSIBLE_CATEGORY_COUNT){
			return false;
		}
		return true;
	}

	public List<String> getCategories() {
		return categories.stream()
				.map(category -> category.getCategoryName())
				.collect(Collectors.toList());
	}
}
