package menu.service;

import menu.domain.Category;
import menu.domain.repository.CategoryRepository;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CategoryService {
    private final InputView in = new InputView();
    private final OutputView out = new OutputView();

    public List<Category> getWeekRandomCategories() {
        List<Category> weekList= new ArrayList<>();
        Category randomCategory;
        for(int i = 0; i < 5;i++){
            do{
                randomCategory = getRandomCategory();
            }while (isCategoryExistOverTwice(weekList, randomCategory));
            weekList.add(randomCategory);
        }
        return weekList;
    }
    private boolean isCategoryExistOverTwice(List<Category> categories,Category category){
        int count = 0;
        for(Category c : categories){
            if(c.equals(category)){
                count++;
            }
        }
        if(count < 2){
            return false;
        }
        return true;
    }

    public List<String> getCategoryMenus(String categoryName){
        return CategoryRepository.findCategoryByName(categoryName).getMenu();
    }
    private Category getRandomCategory(){
        return CategoryRepository.getRandomCategory();
    }

//    public boolean is
}
