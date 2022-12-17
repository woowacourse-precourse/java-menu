package menu;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    String name;
    List<String> hates;
    List<String> recommended;

    Coach(String name, List<String> hates){
        this.name = name;
        this.hates = hates;
        this.recommended = new ArrayList<>();
    }
}
