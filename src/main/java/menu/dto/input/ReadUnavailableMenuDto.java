package menu.dto.input;

import java.util.ArrayList;
import java.util.List;

public class ReadUnavailableMenuDto {
    private final List<String> inputs = new ArrayList<>();

    public void add(String input) {
        this.inputs.add(input);
    }

    public List<String> getInputs() {
        return inputs;
    }
}
