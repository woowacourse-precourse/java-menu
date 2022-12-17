package menu.controller;

import menu.model.coach.Coach;
import menu.model.menu.Menu;
import menu.view.ConsoleInputView;
import menu.view.ConsoleOutputView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class InputManager {
    ConsoleInputView inputView;
    ConsoleOutputView outputView;

    public InputManager() {
        inputView = new ConsoleInputView();
        outputView = new ConsoleOutputView();
    }
    public List<Coach> getCoachListInput() {
        outputView.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        List<String> coachNameList = inputView.readStringList();
        validateCoachNames(coachNameList);

        List<Coach> coachList = new ArrayList<>();
        for(int i = 0; i < coachNameList.size(); i++) {
            coachList.add(new Coach(coachNameList.get(i)));
        }

        return coachList;
    }

    public List<Menu> getMenuListInput(String coachName) {
        outputView.println(coachName + "(이)가 못 먹는 메뉴를 입력해 주세요.");
        List<String> menuNameList = inputView.readStringList();
        validateMenuNames(menuNameList);

        List<Menu> menuList = new ArrayList<>();
        for(int i = 0; i < menuNameList.size(); i++) {
            menuList.add(new Menu(menuNameList.get(i)));
        }

        return menuList;
    }

    private void validateCoachNames(List<String> coachNameList) {
        if(coachNameList.size() != new HashSet<String>(coachNameList).size()) {
            throw new IllegalArgumentException("코치 이름은 중복될 수 없습니다.");
        }
        if(coachNameList.size() > 5 || coachNameList.size() < 2) {
            throw new IllegalArgumentException("코치는 2명이상 5명 이하입니다.");
        }
    }

    private void validateMenuNames(List<String> menuNameList) {
        if(menuNameList.size() != new HashSet<String>(menuNameList).size()) {
            throw new IllegalArgumentException("메뉴 이름은 중복될 수 없습니다.");
        }
        if(menuNameList.size() > 2) {
            throw new IllegalArgumentException("메뉴는 2개 이하로만 고를 수 있습니다.");
        }
    }
}
