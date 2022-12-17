package menu.model;

import java.util.List;

public class Coach {

	private static final int MONDAY = 0;
	private static final int FRIDAY = 4;

	private String name;
	private List<String> notEatFoodList;
	private List<String> recommendFoodList;

	public Coach(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getNotEatFoodList() {
		return notEatFoodList;
	}

	public void setNotEatFoodList(List<String> notEatFoodList) {
		this.notEatFoodList = notEatFoodList;
	}

	public List<String> getRecommendFoodList() {
		return recommendFoodList;
	}

	public void setRecommendFoodList(List<String> recommendFoodList) {
		this.recommendFoodList = recommendFoodList;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ ").append(name).append(" | ");
		for (int day = MONDAY; day < FRIDAY; day++) {
			sb.append(recommendFoodList.get(day)).append(" | ");
		}
		sb.append(recommendFoodList.get(FRIDAY)).append(" ]");
		return sb.toString();
	}

}
