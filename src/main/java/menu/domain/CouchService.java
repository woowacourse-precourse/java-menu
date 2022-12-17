package menu.domain;

import java.util.Arrays;
import java.util.List;

public class CouchService {

    public void registerCouches(String input) {
        String[] couches = input.split(",");
        for (String couch :
                couches) {
            CouchRepository.addCouch(new Couch(couch));
        }
    }

    public void registerCannotEatFoods(Couch couch, String input) {
        String[] foods = input.split(",");
        couch.setCannotEatFoods(Arrays.asList(foods));
    }

    public List<Couch> getCouches() {
        return CouchRepository.couches();
    }

}
