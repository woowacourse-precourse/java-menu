package menu.domain;

import java.util.*;

public class CategoryRepository { // 인터페이스 만들어도 될듯
    private static Map<Integer, Category> categories = new HashMap<>();
    private static Integer sequence = 1;

    private static final CategoryRepository instance = new CategoryRepository();

    private CategoryRepository(){}

    public static CategoryRepository getInstance() {
        return instance;
    }

    public Category save(Category category){
        category.setId(sequence++);
        categories.put(category.getId(),category);
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
