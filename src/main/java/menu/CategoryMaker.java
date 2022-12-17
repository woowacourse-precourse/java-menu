package menu;

import java.util.ArrayList;
import java.util.List;

public class CategoryMaker {

    private final CategoryGenerator categoryGenerator;

    public CategoryMaker(CategoryGenerator categoryGenerator) {
        this.categoryGenerator = categoryGenerator;
    }

    public List<String> makeCategories() {
        List<String> randomCategory = new ArrayList<>();

        while(randomCategory.size()<5){
            String category = findCategory(categoryGenerator.generate());
            System.out.println(isDuplicate(randomCategory,category));
            if(!isDuplicate(randomCategory,category)){

                randomCategory.add(category);
            }
        }
        return randomCategory;
    }

    private String findCategory(int randomNumber) {
        Categories categories = Categories.of(randomNumber);
        String category = categories.getCategory();
        return category;
    }

    public boolean isDuplicate(List<String> randomCategory,String category){
        int count=0;
        for(String random : randomCategory){
            if(random.equals(category)){
                count++;
            }
        }
        if(count>1){
            return true;
        }
        return false;
    }
}
