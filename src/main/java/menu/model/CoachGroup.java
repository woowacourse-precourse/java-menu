package menu.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static menu.util.ErrorMessage.COACH_SIZE_OVER_ERROR_MESSAGE;

public class CoachGroup {

    private static final String SEPARATOR = ",";
    private final List<Coach> coaches;

    public CoachGroup(String names){
        List<String> parseNames = parseName(names);
        validateCoachSize(parseNames);
        coaches = makeCoachGroup(parseNames);
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public List<String> parseName(String names){
        String[] split = names.split(SEPARATOR);
        return Arrays.stream(split).map(s->s.trim()).collect(Collectors.toList());
    }

    public List<Coach> makeCoachGroup(List<String> names){
        return names.stream().map(Coach::new).collect(Collectors.toList());
    }

    public void validateCoachSize(List<String> names){
        if(isCorrectSize(names)){
            return;
        }
        throw new IllegalArgumentException(COACH_SIZE_OVER_ERROR_MESSAGE.getMessage());
    }

    private static boolean isCorrectSize(List<String> names) {
        return names.size() >= 2 && names.size() <= 5;
    }

    public List<List<String>> makeInfos(){
        for (Coach coach : coaches) {
            List<Menu> recommendMenu = coach.getRecommendMenu();
        }
        return coaches.stream()
                .map(c -> c.getRecommendMenu().stream().map(menu -> menu.getName()).collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    public List<String> getNames(){
        return coaches.stream()
                .map(c -> c.getName())
                .collect(Collectors.toList());
    }

    public List<List<String>> makeResult(){
        List<List<String>> infos = makeInfos();
        List<String> names = getNames();
        for (int i = 0; i < infos.size(); i++) {
            infos.get(i).add(0,names.get(i));
        }
        return infos;
    }
}
