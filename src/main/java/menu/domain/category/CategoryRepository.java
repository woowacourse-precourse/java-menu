package menu.domain.category;

import java.util.*;

public class CategoryRepository { // 인터페이스 만들어도 될듯
    private static Map<Integer, Category> categories = new HashMap<>();

    private static final CategoryRepository instance = new CategoryRepository();

    private CategoryRepository(){}

    public static CategoryRepository getInstance() {
        return instance;
    }

    public Category save(int id, Category category){
        categories.put(id,category);
        return category;
    }

    public List<Category> findAll(){
        return new ArrayList<>(categories.values());
    }

    public Category findById(int id){
        return Optional.ofNullable(categories.get(id))
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 해당 미션이 존재하지 않습니다."));
    }
}
