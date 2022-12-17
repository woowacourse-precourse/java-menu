package menu.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.BannedFoods;
import menu.domain.Categories;
import menu.domain.Crew;
import menu.domain.Crews;
import menu.util.CategoryGenerator;
import menu.util.FoodsFiller;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final static int DAYS_START = 0;
    private final static int DAYS_END = 5;
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final CategoryGenerator categoryGenerator = new CategoryGenerator();
    private final FoodsFiller foodsFiller = new FoodsFiller();
    private BannedFoods bannedFoods = new BannedFoods();
    private Categories categories = new Categories();
    private Crews crews;

    public void run() {
        outputView.printStart();
        crews = makeCrews();
        processFillingBannedFoods();
        processFillingFoods();
        outputView.printResult(categories, crews);
    }

    private Crews makeCrews() {
        Crews crewsTemp = new Crews(getCrews());
        return crewsTemp;
    }

    private void processFillingFoods() {
        for (int i = DAYS_START; i < DAYS_END; i++) {
            fillCategory();
            fillFoods(categories.getCategories().get(i));
        }
    }

    private void fillCategory() {
        categoryGenerator.generateCategories(categories);
    }

    private void fillFoods(String category) {
        for (Crew crew : crews.getCrews()) {
            foodsFiller.fillFoods(crew, category, bannedFoods.getBannedFoods());
        }
    }

    private void processFillingBannedFoods() {
        int crewSize = crews.getCrews().size();
        fillBannedFoods(crewSize);
    }

    private void fillBannedFoods(int crewSize) {
        for (int i = 0; i < crewSize; i++) {
            Crew crew = crews.getCrews().get(i);
            outputView.printRequestOfBannedFoods(crew.getName());
            String foods = inputView.readBannedFoods();
            Arrays.stream(foods.split(","))
                    .forEach(name -> bannedFoods.addBannedFood(name));
        }
    }

    private List<Crew> getCrews() {
        outputView.printRequestCrewsName();
        String crewsName = inputView.readCrewsName();
        return Arrays.stream(crewsName.split(","))
                .map(name -> new Crew(name))
                .collect(Collectors.toList());
    }
}
