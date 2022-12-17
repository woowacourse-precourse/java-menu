package menu.domain.service;

import menu.domain.dto.CoachRequestDto;
import menu.domain.dto.RecommendResultDto;
import menu.domain.model.Category;
import menu.domain.model.Coach;
import menu.domain.model.Day;
import menu.domain.model.Menu;
import menu.domain.model.RecommendResult;
import menu.domain.repository.CoachRepository;
import menu.domain.repository.MenuRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MenuRecommendService {

    private static final String ERROR_INVALID_COACH_SIZE = "[ERROR] 최소 2명에서 최대 5명까지 식사를 같이할 수 있습니다.";
    private static final int MINIMUM_COACH_SIZE = 2;
    private static final int MAXIMUM_COACH_SIZE = 5;

    public void createCoach(List<CoachRequestDto> requestDtos) {
        validateCoachSize(requestDtos);
        for (CoachRequestDto requestDto : requestDtos) {
            String name = requestDto.getName();
            List<String> canNotEatFoodsName = requestDto.getCanNotEatFoods();
            List<Menu> canNotEatFoods = MenuRepository.findByNames(canNotEatFoodsName);

            CoachRepository.save(new Coach(name, canNotEatFoods));
        }
    }

    private static void validateCoachSize(List<CoachRequestDto> requestDtos) {
        if (requestDtos.size() < MINIMUM_COACH_SIZE || requestDtos.size() > MAXIMUM_COACH_SIZE) {
            throw new IllegalArgumentException(ERROR_INVALID_COACH_SIZE);
        }
    }

    public List<List<RecommendResultDto>> recommendFoods(CategoryStrategy categoryStrategy, MenuStrategy menuStrategy) {
        List<List<RecommendResultDto>> result = new ArrayList<>();

        List<Coach> coaches = CoachRepository.findAll();
        for (Coach coach : coaches) {
            result.add(recommendFood(coach, categoryStrategy, menuStrategy));
        }
        return result;
    }

    public List<RecommendResultDto> recommendFood(Coach coach, CategoryStrategy categoryStrategy, MenuStrategy menuStrategy) {
        for (Day day : Day.values()) {
            Category category = createCategory(coach, categoryStrategy);
            Menu menu = createMenu(coach, category, menuStrategy);

            RecommendResult recommendResult = new RecommendResult(day, category, menu);
            coach.addRecommendResult(recommendResult);
        }
        return coach.toRecommendResultDto();
    }

    private Category createCategory(Coach coach, CategoryStrategy categoryStrategy) {
        Category category;
        do {
            List<Integer> numbers = Category.getNumbers();
            int number = categoryStrategy.generate(numbers.get(0), numbers.get(numbers.size() - 1));
            category = Category.from(number);
        } while (coach.isDuplicateCategory(category));
        return category;
    }

    private Menu createMenu(Coach coach, Category category, MenuStrategy menuStrategy) {
        List<Menu> menus = MenuRepository.findByCategory(category);
        List<String> menuNames = menus.stream().map(Menu::getName).collect(Collectors.toList());
        Menu menu;
        do {
            String generateMenu = menuStrategy.generate(menuNames).get(0);
            menu = MenuRepository.findMenuByName(generateMenu);
        } while (coach.isDuplicateMenu(menu) || !coach.canEat(menu));
        return menu;
    }
}
