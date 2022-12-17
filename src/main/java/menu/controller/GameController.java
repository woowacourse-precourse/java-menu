package menu.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import com.sun.source.tree.Tree;
import menu.domain.Category;
import menu.domain.CategoryMaker;
import menu.input.InputString;
import menu.input.InputView;
import menu.output.OutputView;

import java.util.*;
import java.util.stream.Collectors;

public class GameController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    Map<String, Set<String>> coachCannotEat = new TreeMap<>();
    Map<String, Set<String>> candidateMenu = new TreeMap<>();

    public void play(){
        outputView.GAME_START_OUTPUT();
        List<Category> categories = CategoryMaker.makeCategories();
        String[] coaches = inputView.INPUT_COACH_NAME();
        fillCannotEatTable(coachCannotEat, candidateMenu, coaches);
        fillMenuTable(categories, coachCannotEat, candidateMenu, coaches);
        outputView.PRINT_RESULT(categories, candidateMenu);
    }

    private static void fillMenuTable(List<Category> categories, Map<String, Set<String>> coachCannotEat, Map<String, Set<String>> candidateMenu, String[] coaches) {
        for (Category category : categories) {
            for (String coach : coaches) {
                candidate(coachCannotEat, candidateMenu, category, coach);
            }
        }
    }

    private void fillCannotEatTable(Map<String, Set<String>> coachCannotEat, Map<String, Set<String>> candidateMenu, String[] coaches) {
        for(int i = 0; i< coaches.length; i++){
            String[] menus = inputView.CANNOT_EAT_FOOD(coaches[i]);
            coachCannotEat.put(coaches[i], Arrays.stream(menus).collect(Collectors.toSet()));
            candidateMenu.put(coaches[i], new LinkedHashSet<>());
        }
    }

    private static void candidate(Map<String, Set<String>> coachCannotEat, Map<String, Set<String>> candidateMenu, Category category, String coach) {
        while(true){
            String menu = Randoms.shuffle(category.getMenus()).get(0);
            Set<String> strings = candidateMenu.get(coach);
            if(strings.contains(menu)) continue;
            Set<String> strings1 = coachCannotEat.get(coach);
            if(strings1.contains(menu)) continue;
            strings.add(menu);
            candidateMenu.put(coach, strings);
            break;
        }
    }

}
