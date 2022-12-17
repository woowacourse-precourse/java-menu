package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Coach {

	private static final int MONDAY = 0;
	private static final int FRIDAY = 4;

	private String name;
	private List<String> notEatFoodList;
	private List<String> recommendFoodList;
	private List<Category> categoryList;

	public Coach(String name) {
		this.name = name;
		this.categoryList = new ArrayList<>();
		this.recommendFoodList = new ArrayList<>();
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

	public boolean isCategorySizeFull() {
		return this.categoryList.size() < 5;
	}

	public void setCategory(Category category) {
		for (Category getCategory : this.categoryList) {
			if (getCategory.equals(category)) {
				return;
			}
		}
		this.categoryList.add(category);
	}

	public boolean isRecommendFoodListSizeFull() {
		return this.recommendFoodList.size() < 5;
	}

	public void setRecommendFood(String menu) {
		if (this.notEatFoodList.contains(menu)) {
			return;
		}
		if (this.recommendFoodList.contains(menu)) {
			return;
		}
		this.recommendFoodList.add(menu);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ ").append(this.name).append(" | ");
		for (int day = MONDAY; day < FRIDAY; day++) {
			sb.append(this.recommendFoodList.get(day)).append(" | ");
		}
		sb.append(this.recommendFoodList.get(FRIDAY)).append(" ]");
		return sb.toString();
	}

}
