package menu.domains;

import menu.views.ProgramOutput;
import menu.views.UserInput;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    String name;
    List<String> cannotEatMenus;
    List<String> suggestedMenus;

    public Coach(String name) {
        this.name = name;
        this.cannotEatMenus = new ArrayList<>();
        this.suggestedMenus = new ArrayList<>();
    }

    public void updateCannotHaveMenu(UserInput input, ProgramOutput output){
        output.printRequestNotHaveMenu(this.name);
        List<String> cannotHaveMenu = input.requestCannotEatMenu();
        cannotEatMenus.addAll(cannotHaveMenu);
    }
}
