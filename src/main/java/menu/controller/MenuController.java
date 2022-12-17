package menu.controller;

import menu.domain.Coach;
import menu.domain.Recommend;
import menu.repository.CoachRepository;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MenuController {
    private CoachRepository coachRepository;

    public MenuController() {
        coachRepository = new CoachRepository();
    }

    public void start() {
        OutputView.printStartComment();
        // 코치들 입력받음
        List<String> names = inputCoachNames();

        // 코치들별로 못먹는 음식 입력받기
        List<Coach> coaches = inputForbiddenFoodsOfCoaches(names);
        // 추천 카테고리는 만듦
        Recommend recommend = new Recommend();
        // 코치별로 메뉴 만들어줌
        coaches = makeTotalMenus(coaches, recommend);
        coachRepository.setCoaches(coaches);
        // 출력
        List<String> categories = recommend.getCategories();
        OutputView.printResultComment();
        OutputView.printTotalRecommendResult(categories, coachRepository);
    }

    private List<Coach> makeTotalMenus(List<Coach> coaches, Recommend recommend) {
        List<Coach> newCoaches = new ArrayList<>();
        for (int i = 0; i < coaches.size(); i++) {
            Coach nowCoach = coaches.get(i);
            List<String> recommendFoods = recommend.generateRecommendMenus(nowCoach);
            nowCoach.setRecommendFoods(recommendFoods);
            newCoaches.add(nowCoach);
        }

        return newCoaches;
    }

    private List<Coach> inputForbiddenFoodsOfCoaches(List<String> names) {
        List<Coach> coaches = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            OutputView.printCoachForbiddenFoodComment(name);
            // 해당 코치의 못먹는 음식 리스트 입력받음
            List<String> foods = InputView.readForbiddenFoods();

            coaches.add(new Coach(name, foods));
        }

        return coaches;
    }

    private List<String> inputCoachNames() {
        OutputView.printCoachNameComment();
        List<String> names = InputView.readNames();
        System.out.println();

//        List<String> names = new ArrayList<>();
//        try {
//            OutputView.printCoachNameComment();
//            names = InputView.readNames();
//            System.out.println();
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//            inputCoachNames();
//        }

        return names;
    }
}
