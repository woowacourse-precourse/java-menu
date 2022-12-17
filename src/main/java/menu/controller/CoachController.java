package menu.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.repository.CoachRepository;
import menu.repository.MenuRepository;
import menu.view.InputView;

public class CoachController {

    public void addCoaches() {
        addCoachesByName();
        addNoEatableMenuOfCoaches(CoachRepository.coaches());
    }

    private void addCoachesByName() {
        List<Coach> coaches = createCoachesByNames(getParsedCoachNames());
        if (coaches.size() < 2 || coaches.size() > 5) {//TODO validate 분리 필요, 매직넘버제거
            throw new IllegalArgumentException("[ERROR] 코치는 최소 2명, 최대 5명끼리 식사합니다.");
        }
        CoachRepository.addAll(coaches);
    }

    private List<Coach> createCoachesByNames(List<String> names) {
        List<Coach> coaches = new ArrayList<>();
        for (String name : names) {
            validateName(name);
            coaches.add(new Coach(name));
        }
        return coaches;
    }

    private void validateName(String name) {
        if (name.length() < 2 || name.length() > 4) { //TODO validate 분리 필요, 매직넘버제거
            throw new IllegalArgumentException("[ERROR] 코치의 이름은 2글자이상, 4글자이하여야합니다.");
        }
    }

    private List<String> getParsedCoachNames() {
        String names = InputView.inputCoachNames();
        return Arrays.stream(names.split(",")).collect(Collectors.toList());
    }

    private void addNoEatableMenuOfCoaches(List<Coach> coaches) {
        for(Coach coach : coaches){
            addNoEatableMenuOfCoach(coach);
        }
    }

    private void addNoEatableMenuOfCoach(Coach coach) {
        String inputNoEatableMenus = InputView.inputNoEatableMenus(coach.getName());
        List<Menu> parsedMenus = getParsedNoEatableMenu(inputNoEatableMenus);
        if(parsedMenus == null){
            return;
        }
        coach.addNoEatableMenuAll(parsedMenus);
        // update coach
        CoachRepository.update(CoachRepository.getIndex(coach), coach);
    }

    private List<Menu> getParsedNoEatableMenu(String inputNoEatableMenus) { //TODO Parsing util클래스 생성
        List<String> parsedNames = Arrays.stream(inputNoEatableMenus.split(",")).collect(Collectors.toList());
        validateNoEatableMenuSize(parsedNames.size());
        if(parsedNames.get(0).equals("")){
            return null;
        }
        return Arrays.stream(inputNoEatableMenus.split(",")).map(parsedName -> {
            return MenuRepository.findByName(parsedName);
        }).collect(Collectors.toList());
    }

    private void validateNoEatableMenuSize(int size) {
        if(size > 2){
            throw new IllegalArgumentException("[ERROR] 코치당 먹을 수 없는 메뉴는 최대 2개까지 입력할 수 있습니다.");
        }
    }
}
