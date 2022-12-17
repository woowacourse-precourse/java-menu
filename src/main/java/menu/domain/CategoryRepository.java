package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepository { // 인터페이스 만들어도 될듯
    private List<Category> categories = new ArrayList<>();

    private static final CategoryRepository instance = new CategoryRepository();

    public static CategoryRepository getInstance() {
        return instance;
    }

    public Category save(Category category){
        categories.add(category);
        return category;
    }

    public List<Category> findALl(){
        return new ArrayList<>(categories);
    }
}
