package menu.views;

public class Validator {

    public boolean validateCoachList(String[] userInput){
        boolean isAllRight = true;
        try{
            validateCoachNumber(userInput);
            validateCoachNameLength(userInput);
        }catch(IllegalArgumentException ex){
            isAllRight = false;
        }
        return isAllRight;
    }

    private void validateCoachNumber(String[] coaches){
        if(!(2 <= coaches.length && coaches.length <= 5)){
            String errorMessage = "[ERROR] 입력해 주시는 코치님들의 숫자는 2~5명 사이로 다시 입력해 주십시오.";
            errorProcess(errorMessage);
        }
    }

    private void validateCoachNameLength(String[] coaches){
        for (String coach : coaches) {
            int nameLength = coach.length();
            if (!(2 <= nameLength && nameLength <= 4)) {
                String errorMessage = "[ERROR] 코치님들의 이름은 2글자에서 4글자 사이여야 합니다. 다시 입력해주세요.";
                errorProcess(errorMessage);
            }
        }
    }

    private void errorProcess(String errorMessage){
        ProgramOutput.printStatement(errorMessage);
        throw new IllegalArgumentException();
    }
}
