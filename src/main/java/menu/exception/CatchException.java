package menu.exception;

import java.util.Set;

import static menu.exception.ExceptionMassage.*;

public class CatchException {
    private void throwException(String error){
        throw new IllegalArgumentException(error);
    }
    public void inputOverCoachCntException(String input){
        String[] inputArr = input.split(",");
        if(inputArr.length>5) throwException(COACH_CNT_ERROR.getError());
        if(inputArr.length<2) throwException(COACH_CNT_ERROR.getError());
    }
    public void coachNameLimitException(String input){
        String[] inputArr = input.split(",");
        for(String coach: inputArr){
            if(coach.length()>4) throwException(COACH_NAME_LENGTH_ERROR.getError());
            if(coach.length()<2) throwException(COACH_NAME_LENGTH_ERROR.getError());
        }
    }
    public void sameNameException(String input){
        String[] inputArr = input.split(",");
        Set<String> inputSet = Set.of(inputArr);
        if(inputArr.length!=inputSet.size()) throwException(SAME_NAME_EXCEPTION.getError());
    }
}
