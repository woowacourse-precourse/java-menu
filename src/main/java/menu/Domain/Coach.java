package menu.Domain;

import camp.nextstep.edu.missionutils.Randoms;
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
    }

    public void setAllergic(List<String> allergy){
        this.allergic = allergy;
    }

    public void setCategory(List<String> category){
        this.recommandatedcategory = category;
    }

    public void out(){
        OutputView.printCategory(name, result);
    }

    public void recommandMenu(){
        for (String category:
             recommandatedcategory) {
            List<String> menus = database.get(category);
            result.add(getMenu(menus));
        }
    }

    private String getMenu(List<String> menus){
        while(true){
            String menu = Randoms.shuffle(menus).get(0);
            if(!allergic.contains(menu)){
                return menu;
            }
        }
    }

}
