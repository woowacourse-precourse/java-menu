package menu.view;

import java.util.Scanner;

public class Input {
    private final Scanner scanner = new Scanner(System.in);

    public String readCoachName() {
        return read();
    }

    public String read() {
        return scanner.nextLine();
    }
}
