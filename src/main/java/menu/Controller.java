package menu;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    List<Coach> coaches = new ArrayList<>();
    MenuSelector menuSelector = new MenuSelector();

    public void initGame() {
        System.out.println(Output.INIT);
        System.out.println(Output.INPUT_COACH);
        String[] names = Input.inputName();
        for (String name : names) {
            System.out.printf((Output.INPUT_HATE) + "%n", name);
            List<String> hates = Input.inputHate();
            coaches.add(new Coach(name, hates));
        }
    }
}
