package menu.view;

import java.util.Scanner;

public class InputView {

    private static final String SEPARATOR = ",";
    private final Scanner scanner = new Scanner(System.in);

    public String[] readCoachNames() {
        return scanner.nextLine().split(SEPARATOR);
    }

}
