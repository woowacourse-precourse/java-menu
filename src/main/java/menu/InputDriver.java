package menu;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputDriver {
    OutputDriver outputDriver = new OutputDriver();
    // 구분자가 앞 뒤로 있는 경우 에러
    // 코치의 이름이 2-4 가 안되는 경우
    // 코치의 명 수가 2-5 명인 경우
    public String scanCoachName() {
        return checkIfValidStringForNameList(Console.readLine());
    }

    private String checkIfValidStringForNameList(String readLine) {
        checkIfSplitValid(readLine);
        checkIfNameLengthValid(readLine);
        checkIfCoachNumberValid(readLine);
        return readLine;
    }

    private void checkIfSplitValid(String readLine) {
        if (List.of(readLine.split(",")).contains("")){
            outputDriver.printErrorForScanSpliting();
            throw new IllegalArgumentException();
        }
    }

    private void checkIfCoachNumberValid(String readLine) {
        if (List.of(readLine.split(",")).size() < 2){
            outputDriver.printErrorForScanTooLessCoach();
            throw new IllegalArgumentException();
        }
        if (List.of(readLine.split(",")).size() > 5){
            outputDriver.printErrorForScanTooManyCoach();
            throw new IllegalArgumentException();
        }
    }

    private void checkIfNameLengthValid(String readLine) {
        for (String name: List.of(readLine.split(","))){
            if (name.length() < 2 || name.length() > 4){
                throw new IllegalArgumentException();
            }
        }
    }


    // 구분자가 앞뒤로 있는 경우 에러
    // 0-2 개 초과인 경우 에러
    public String scanCannotEatMenu() {
        return checkIfValidStringForMenuList(Console.readLine());

    }

    private String checkIfValidStringForMenuList(String readLine) {
        checkIfSplitMenuValid(readLine);
        checkIfSplitMenuWithNoSpace(readLine);
        checkIfMenuNumberValid(readLine);
        return readLine;
    }

    private void checkIfSplitMenuWithNoSpace(String readLine) {
        for (String menu : List.of(readLine.split(","))){
            if (menu.contains(" ")){
                outputDriver.printErrorForScanMenuHasSpace();
                throw new IllegalArgumentException();
            }
        }
    }

    private void checkIfSplitMenuValid(String readLine) {
        if (List.of(readLine.split(",")).contains("")){
            outputDriver.printErrorForScanMenuSpliting();
            throw new IllegalArgumentException();
        }
    }

    private void checkIfMenuNumberValid(String readLine) {
        if (List.of(readLine.split(",")).size() > 2 ){
            outputDriver.printErrorForScanMenuNumber();
            throw new IllegalArgumentException();
        }
    }
}
