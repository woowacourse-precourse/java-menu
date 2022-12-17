package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Coach {

	private String name;
	private List<String> notEatFoodList;
	private List<String> recommendFoodList;
	private List<Category> categoryList;

	public Coach(String name) {
		this.name = name;
		this.categoryList = new ArrayList<>();
		this.recommendFoodList = new ArrayList<>();
	}

	public boolean addCategoryList(Category category) {
		int duplicateCount = 0;
		for (Category getCategory : categoryList) {
			if (category.equals(getCategory)) {
				duplicateCount++;
			}
		}
		if (duplicateCount > 2) {
			return false;
		}

		this.categoryList.add(category);
		return true;
	}

	public boolean addRecommendList(String food) {
		if (this.recommendFoodList.contains(food)) {
			return false;
		}
		if (this.notEatFoodList.contains(food)) {
			return false;
		}
		this.recommendFoodList.add(food);
		return true;
	}

	public String getName() {
		return name;
	}

	public List<Category> getCategoryList() {
		return this.categoryList;
	}

	public void setNotEatFoodList(List<String> notEatFoodList) {
		this.notEatFoodList = notEatFoodList;
	}

	public String getRecommendFoodList() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ ").append(this.name).append(" | ");
		for (int day = 0; day < recommendFoodList.size() - 1; day++) {
			sb.append(this.recommendFoodList.get(day)).append(" | ");
		}
		sb.append(this.recommendFoodList.get(recommendFoodList.size() - 1)).append(" ]");
		return sb.toString();
	}

}
