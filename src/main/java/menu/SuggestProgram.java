package menu;

import menu.domains.Categories;
import menu.domains.Coach;
import menu.views.ProgramOutput;
import menu.views.UserInput;

import java.util.ArrayList;
import java.util.List;

public class SuggestProgram {

    private final UserInput userInput = new UserInput();
    private final ProgramOutput output = new ProgramOutput();
    private final MenuSuggester suggester = new MenuSuggester();

    public void startProgram(){
        output.suggestProgramStart();
        output.printRequestCoachNames();
        List<String> coachesName = userInput.requestCoachName();
        List<Coach> coaches = makeCoachList(coachesName);
        addCannotHaveMenu(coaches);
        makeMenuSuggestResult(coaches);
    }

    private List<Coach> makeCoachList(List<String> coaches){
        List<Coach> coachList = new ArrayList<>();
        for (String coach : coaches) {
            coachList.add(new Coach(coach));
        }
        return coachList;
    }

    private void addCannotHaveMenu(List<Coach> coaches){
        for (Coach coach : coaches) {
            coach.updateCannotHaveMenu(userInput, output);
        }
    }

    private void makeMenuSuggestResult(List<Coach> coaches){

        List<Categories> suggestedCategory = suggester.categorySuggest();

        for (Coach coach : coaches) {
            coach.updateSuggestedMenus(suggestedCategory);
        }


    }
}
