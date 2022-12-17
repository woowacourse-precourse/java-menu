package menu;

import java.util.ArrayList;
import java.util.List;

public class CategoryMaker {

    private final CategoryGenerator categoryGenerator;

    public CategoryMaker(CategoryGenerator categoryGenerator) {
        this.categoryGenerator = categoryGenerator;
    }

    public List<Integer> makeCategories() {
        List<Integer> randomCategory = new ArrayList<>();

        while(randomCategory.size()<5){
            int category = categoryGenerator.generate();
            if(!isDuplicate(randomCategory,category)){
                randomCategory.add(category);
            }
        }
        return randomCategory;
    }

    public boolean isDuplicate(List<Integer> randomCategory,int category){
        int count=0;
        for(int random : randomCategory){
            if(random==category){
                count++;
            }
        }
        if(count>1){
            return true;
        }
        return false;
    }
}
