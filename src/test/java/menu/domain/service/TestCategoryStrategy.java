package menu.domain.service;

import java.util.List;

public class TestCategoryStrategy implements CategoryStrategy{

    private final List<Integer> list;

    public TestCategoryStrategy(List<Integer> list) {
        this.list = list;
    }

    @Override
    public int generate(int inclusiveStart, int inclusiveEnd) {
        return list.remove(0);
    }
}
