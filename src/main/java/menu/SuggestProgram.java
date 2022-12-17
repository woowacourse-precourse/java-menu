package menu;

import menu.views.ProgramOutput;
import menu.views.UserInput;

import java.util.List;

public class SuggestProgram {

    private final UserInput userInput = new UserInput();
    private final ProgramOutput output = new ProgramOutput();

    public void startProgram(){
        output.suggestProgramStart();
        output.printRequestCoachNames();
        List<String> coaches = userInput.requestCoachName();
    }
}
