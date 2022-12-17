package menu.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestListGenerator implements ListGenerator{
    @Override
    public List<String> getShuffledList(List<String> list) {
        List<String> temp = new ArrayList<>(list);
        list.remove(0);
        return temp;
    }
}
