package menu;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private String name;
    private List<String> hates;
    private List<String> recommended;

    Coach(String name, List<String> hates){
        this.name = name;
        this.hates = hates;
        this.recommended = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getRecommended() {
        return recommended;
    }

    public boolean isPossible(String curMenu){
        if(hates.contains(curMenu)){
            return false;
        }
        if(recommended.contains(curMenu)){
            return false;
        }
        return true;
    }

    public void addRecommend(String curMenu){
        recommended.add(curMenu);
    }
}
