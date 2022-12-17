package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.validator.NameValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static List<String> readNames() {
        List<String> names = new ArrayList<>();
        NameValidator nameValidator = new NameValidator();
        String inputNames = Console.readLine();

        String[] splitNames = inputNames.split(",");
        for(int i=0; i< splitNames.length; i++) {
            names.add(splitNames[i]);
        }
        nameValidator.validate(names);
        return names;
    }
}
