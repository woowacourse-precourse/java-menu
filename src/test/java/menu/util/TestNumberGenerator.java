package menu.util;

public class TestNumberGenerator implements NumberGenerator{
    int i = -1;
    @Override
    public Integer generateCategoryIdx() {
        i += 1;
        return i;
    }
}
