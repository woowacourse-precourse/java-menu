package menu.Domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.Util.ErrorMessage;
import menu.Util.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Coach {
    public String name;
    private List<String> allergic;
    private List<String> recommandatedcategory;
    private List<String> result;
    private HashMap<String, List<String>> database;

    public Coach(String name, HashMap<String, List<String>> database) {
        this.name = name;
        this.database = database;
        this.result = new ArrayList<>();
        this.recommandatedcategory = new ArrayList<>();
    }

    public void setAllergic(List<String> allergy) {
        validate(allergy);
        this.allergic = allergy;
    }

    public void setCategory(String category) {
        this.recommandatedcategory.add(category);
    }

    public void out() {
        OutputView.printCategory(name, result);
    }

    public void recommandMenu(String category) {
        result.add(getMenu(database.get(category)));
    }

    private String getMenu(List<String> m) {
        while (true) {
            List<String> result = Randoms.shuffle(m);
            String menu = result.get(0);
            if (!this.allergic.contains(menu) || !this.result.contains(menu)) {
                return menu;
            }
        }
    }

    private void validate(List<String> allergic) {
        for (String tmp :
                allergic) {
            if (!valid(tmp)) {
                throw new IllegalArgumentException(ErrorMessage.NoSuchFood.getMessage());
            }
        }
    }

    private boolean valid(String allergy) {
        for (List<String> foods :
                database.values()) {
            if (foods.contains(allergy)) {
                return true;
            }
        }
        return false;
    }
}
