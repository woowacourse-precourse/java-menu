package menu.View;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static menu.Constant.Message.*;

public class InputView {
    public List<String> readCoaches() {
        List<String> coaches;
        while(true){
            try{
                coaches = parseCoachName(readLine());
                return coaches;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public List<String> parseCoachName(String input){
        List<String> names = Arrays.asList(input.split(","));

        checkNameNumException(names);
        checkNameLengthException(names);

        return names;
    }

    private void checkNameNumException(List<String> names){
        if(names.size() < 2 || names.size() >5){
            throw new IllegalArgumentException(ERROR_COACH_NUM);
        }
    }

    private void checkNameLengthException(List<String> names){
        for(String name: names){
            if(name.length() < 2 || name.length()>4){
                throw new IllegalArgumentException(ERROR_COACH_LENGTH);
            }
        }
    }

    public List<String> readHateMenus() {
        List<String> hates;
        while(true){
            try{
                hates = parseHateMenus(readLine());
                return hates;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public List<String> parseHateMenus(String input){
        List<String> hates = Arrays.asList(input.split(","));

        checkHateNumException(hates);

        return hates;
    }

    private void checkHateNumException(List<String> names){
        if(names.size() > 2){
            throw new IllegalArgumentException(ERROR_HATE_NUM);
        }
    }

}
