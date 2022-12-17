package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Category {
    private final String name ;
    private final List<String> menus;


    public Category(String categoryName, String ... menus){
        this.name = categoryName;
        this.menus = new ArrayList<>(Arrays.asList(menus));
    }
    public String getName() {
        return name;
    }

    public List<String> getMenu() {
        return Collections.unmodifiableList(menus);
    }

    public String getRandomMenu(){
        return Randoms.shuffle(getMenu()).get(0);
    }

}
