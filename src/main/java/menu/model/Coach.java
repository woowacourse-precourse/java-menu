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

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

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

	public boolean isRecommendFoodListSizeFull() {
		return this.recommendFoodList.size() < 5;
	}

	public boolean setRecommendFood(String menu) {
		if (this.notEatFoodList.contains(menu)) {
			return false;
		}
		if (this.recommendFoodList.contains(menu)) {
			return false;
		}
		this.recommendFoodList.add(menu);
		return true;
	}

	public String getRecommendFoodList() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ ").append(this.name).append(" | ");
		for (int day = MONDAY; day < FRIDAY; day++) {
			sb.append(this.recommendFoodList.get(day)).append(" | ");
		}
		sb.append(this.recommendFoodList.get(FRIDAY)).append(" ]");
		return sb.toString();
	}

}
