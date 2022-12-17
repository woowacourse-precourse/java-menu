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

        for (Categories categories : suggestedCategory) {
            for (Coach coach : coaches) {
                coach.updateSuggestedMenus(categories);
            }
        }
        // 이렇게 주지 말고, 월요일이면 월요일쭉, 화요일이면 화요일 쭉 으로 바꿔서 하자.
        // 그렇게 해야, 테스트 케이스를 성공시킬 수 있다.


        output.printSuggestedMenuResult(suggestedCategory,coaches);
        output.printSuggestingEnd();
    }
}
