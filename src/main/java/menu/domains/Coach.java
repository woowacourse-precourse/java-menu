package menu.domains;

import camp.nextstep.edu.missionutils.Randoms;
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

    public void updateSuggestedMenus(List<Categories> categories){
        for(int menuIndex = 0; menuIndex < 5;){
            List<String> menuList = Categories.getMenuList(categories.get(menuIndex));
            String suggestedMenu = Randoms.shuffle(menuList).get(0);
            if(isValidMenu(suggestedMenu)){
                suggestedMenus.add(suggestedMenu);
                menuIndex++;
            }
        }
    }
    private boolean isValidMenu(String suggestedMenu){
        return !(this.suggestedMenus.contains(suggestedMenu) || this.cannotEatMenus.contains(suggestedMenu));
    }
}
