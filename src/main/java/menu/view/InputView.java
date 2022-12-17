package menu.view;

import menu.validator.NameValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static List<String> readNames() {
        Scanner scanner = new Scanner(System.in);
        List<String> names = new ArrayList<>();
        NameValidator nameValidator = new NameValidator();
        String inputNames = scanner.nextLine();
        scanner.close();

        String[] splitNames = inputNames.split(",");
        for(int i=0; i< splitNames.length; i++) {
            names.add(splitNames[i]);
        }
        nameValidator.validate(names);
        return names;
    }
}
