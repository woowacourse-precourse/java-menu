package menu.view;

import java.util.List;

public class OutputView {

    public void printErrorMessage(String input) {
        System.out.println("[ERROR]" + input);
    }

    public void printList(List<String> inputs) {
        inputs.stream().forEachOrdered(System.out::println);
    }
}
