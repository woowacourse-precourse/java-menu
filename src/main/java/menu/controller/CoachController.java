package menu.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Coach;
import menu.repository.CoachRepository;
import menu.view.InputView;

public class CoachController {

    public void addCoaches(){
        addCoachesByName();

    }

    public void addCoachesByName(){
        List<Coach> coaches = createCoachesByNames(getParsedCoachNames());
        if(coaches.size() < 2 || coaches.size() > 5){//TODO validate 분리 필요, 매직넘버제거
            throw new IllegalArgumentException("[ERROR] 코치는 최소 2명, 최대 5명끼리 식사합니다.");
        }
        CoachRepository.addAll(coaches);
    }

    private List<Coach> createCoachesByNames(List<String> names){
        List<Coach> coaches = new ArrayList<>();
        for(String name : names){
            validateName(name);
            coaches.add(new Coach(name));
        }
        return coaches;
    }

    private void validateName(String name){
        if(name.length() < 2 || name.length() > 4){ //TODO validate 분리 필요, 매직넘버제거
            throw new IllegalArgumentException("[ERROR] 코치의 이름은 2글자이상, 4글자이하여야합니다.");
        }
    }

    public List<String> getParsedCoachNames(){
        String names = InputView.inputCoachNames();
        return Arrays.stream(names.split(", ")).collect(Collectors.toList());
    }
}
