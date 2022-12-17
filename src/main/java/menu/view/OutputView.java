package menu.view;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public void printErrorMessage(String input) {
        System.out.println("[ERROR]" + input);
    }

    public void printList(List<String> inputs) {
        inputs.stream().forEachOrdered(System.out::println);
    }

    public void printResult(List<String> inputs) {
        System.out.println(inputs.stream().collect(Collectors.joining(" | ", "[ ", " ]")));
    }
}
