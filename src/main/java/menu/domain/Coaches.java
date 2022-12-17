package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coaches {

    private static final String ERROR_DIVIDE = "[ERROR] 이름을 ','로 분류해주세요";
    private static final String ERROR_LENGTH = "[ERROR] 코치는 최소 2명 이상 최대 5명 이하여야 합니다.";
    private static final String ERROR_NAME_LENGTH = "[ERROR] 코치의 이름은 2글자 이상, 4글자 이하여야 합니다.";

    List<Coach> coachList;

    public Coaches(String coachesName){
        validate(coachesName);
        makeCoachList(coachesName);
    }

    private void makeCoachList(String coachesName) {
        String [] names = makeArray(coachesName);
        List<Coach>coachList = new ArrayList<>();
        for(String name : names){
            coachList.add(new Coach(name));
        }
        this.coachList = coachList;
    }

    private void validate(String coachesName) {
        String [] names = makeArray(coachesName);
        validateDivide(coachesName, names);
        validateNumberOfCoaches(names);
        validateEachName(names);
    }

    private String[] makeArray(String coachesName) {
        String[] tmpArray = coachesName.split(",");
        for(int i=0;i< tmpArray.length;i++){
            tmpArray[i] = tmpArray[i].replace(" ", "");
        }
        return tmpArray;
    }

    private void validateEachName(String[] coachesName) {
        for(String eachName : coachesName){
            if(eachName.length()<2||eachName.length()>4){
                throw new IllegalArgumentException(ERROR_NAME_LENGTH);
            }
        }
    }

    private void validateNumberOfCoaches(String[] coachesName) {
        if(coachesName.length<2||coachesName.length>5){
            throw new IllegalArgumentException(ERROR_LENGTH);
        }

    }

    private void validateDivide(String inputNames, String[] coachesName) {
        if (countChar(inputNames, ',')+1 != coachesName.length) {
            throw new IllegalArgumentException(ERROR_DIVIDE);
        }
    }

    private static long countChar(String str, char ch) {
        return str.chars()
                .filter(c -> c == ch)
                .count();
    }

    public List<Coach> getCoaches() {
        return coachList;
    }
}
