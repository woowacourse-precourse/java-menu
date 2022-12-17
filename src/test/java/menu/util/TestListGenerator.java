package menu.util;

import java.util.List;

public class TestListGenerator implements ListGenerator{
    @Override
    public List<String> getShuffledList(List<String> list) {
        list.remove(0);
        return list;
    }
}
