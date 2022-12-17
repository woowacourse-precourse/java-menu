package menu;

import menu.domains.Coach;
import menu.views.ProgramOutput;
import menu.views.UserInput;

import java.util.ArrayList;
import java.util.List;

public class SuggestProgram {

    private final UserInput userInput = new UserInput();
    private final ProgramOutput output = new ProgramOutput();

    public void startProgram(){
        output.suggestProgramStart();
        output.printRequestCoachNames();
        List<String> coachesName = userInput.requestCoachName();
        List<Coach> coaches = makeCoachList(coachesName);

    }

    private List<Coach> makeCoachList(List<String> coaches){
        List<Coach> coachList = new ArrayList<>();
        for (String coach : coaches) {
            coachList.add(new Coach(coach));
        }
        return coachList;
    }
}
