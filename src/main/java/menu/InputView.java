package menu;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    Validate validate = new Validate();
    public List<String> readCoachName(){
        while (true){
            System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
            String input = Console.readLine();
            if (validate.isValidCoachName(input)){
                return (Arrays.asList(input.split(",")));
            }
        }
    }

    public List<Coach> readDislikeFood(List<String> coachName){
        List<Coach> coach = new ArrayList<>();
        for (String name : coachName){
            while (true) {
                System.out.println(name + "(이)가 못 먹는 메뉴를 입력해 주세요.");
                String input = Console.readLine();
                if (input.length() == 0){
                    coach.add(new Coach(name, null));
                    break ;
                }
                if (validate.isValidDislikeFood(input)){
                    coach.add(new Coach(name, Arrays.asList(input.split(","))));
                    break ;
                }
            }
        }
        return coach;
    }
}
