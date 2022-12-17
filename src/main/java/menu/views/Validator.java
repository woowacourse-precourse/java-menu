package menu.views;

public class Validator {

    public boolean validateCoachList(String[] userInput){
        boolean isAllRight = true;
        try{
            validateCoachNumber(userInput);
        }catch(IllegalArgumentException ex){
            isAllRight = false;
        }
        return isAllRight;
    }

    private void validateCoachNumber(String[] coaches){
        if(!(2 <= coaches.length && coaches.length <= 5)){
            String errorMessage = "[ERROR] 입력해 주시는 코치님들의 숫자는 2~5명 사이로 입력해 주십시오.";
            errorProcess(errorMessage);
        }
    }

    private void errorProcess(String errorMessage){
        ProgramOutput.printStatement(errorMessage);
        throw new IllegalArgumentException();
    }
}
