package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.view.util.CoachNameInputValidator;
import menu.view.util.DefaultInputValidator;
import menu.view.util.ExcludeFoodInputValidator;
import menu.view.util.constant.CommandMessage;
import menu.view.util.constant.ErrorMessage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InputView {
    private final DefaultInputValidator defaultValidator = new DefaultInputValidator();
    private final ExcludeFoodInputValidator foodInputValidator = new ExcludeFoodInputValidator();
    private final CoachNameInputValidator coachNameInputValidator = new CoachNameInputValidator();
    private final OutputView out = new OutputView();

    public List<String> readCoach(){
        out.print(CommandMessage.REQUEST_NAME.getMessage());
        String coachName ;
        do{
            coachName = Console.readLine();
        }while (!checkNames(coachName));
        out.printBlankLine();
        return Arrays.asList(coachName.split(","));
    }
    private boolean checkNames(String coachNames){
        try {
            defaultValidator.validateBlank(coachNames);
            defaultValidator.validateSeparator(coachNames);
            coachNameInputValidator.validate(coachNames.split(","));
            return true;
        }catch (IllegalArgumentException ie){
            System.out.println(ie.getMessage());
            return false;
        }
    }

    public List<String> readExcludeFoods(){
        String foodNames ;
        do{
            foodNames = Console.readLine();
            if (foodNames.isBlank()){
                return Collections.emptyList();
            }
        }while (!checkFoods(foodNames));
        out.printBlankLine();
        return Arrays.asList(foodNames.split(","));
    }
    private boolean checkFoods(String foodNames){
        try {
            defaultValidator.validateSeparator(foodNames);
            foodInputValidator.validate(foodNames.split(","));
            return true;
        }catch (IllegalArgumentException ie){
            System.out.println(ie.getMessage());
            return false;
        }
    }
}
