package menu;

import camp.nextstep.edu.missionutils.Console;

import java.util.Collections;
import java.util.List;

public class InputDriver {
    OutputDriver outputDriver = new OutputDriver();
    public String scanCoachName() {
        return checkIfValidStringForNameList(Console.readLine());
    }

    public String checkIfValidStringForNameList(String readLine) {
        checkIfSplitValid(readLine);
        checkIfNoSameName(readLine);
        checkIfNameLengthValid(readLine);
        checkIfCoachNumberValid(readLine);
        return readLine;
    }

    private void checkIfNoSameName(String readLine) {
        for (String name : List.of(readLine.split(","))) {
            if (Collections.frequency(List.of(readLine.split(",")), name) > 1) {
                outputDriver.printErrorForSameName();
                throw new IllegalArgumentException();
            }
        }
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

    public String scanCannotEatMenu() {
        return checkIfValidStringForMenuList(Console.readLine());

    }

    public String checkIfValidStringForMenuList(String readLine) {
        checkIfSplitMenuValid(readLine);
        checkIfMenuNumberValid(readLine);
        return readLine;
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
